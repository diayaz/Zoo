import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "Diasik228";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addAnimal(Animal a) {
        String sql = "INSERT INTO animals (name, species, animal_type, age) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getSpecies());
            pstmt.setString(3, a.getType());
            pstmt.setInt(4, a.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // ЧТЕНИЕ + СОРТИРОВКА (теперь с направлением: ASC или DESC)
    public List<Animal> getAnimalsSorted(String orderBy, String direction) {
        List<Animal> list = new ArrayList<>();
        // SQL: ORDER BY age ASC (от малого) или DESC (от большого)
        String sql = "SELECT * FROM animals ORDER BY " + orderBy + " " + direction;
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Animal(rs.getString("name"), rs.getString("species"), rs.getString("animal_type"), rs.getInt("age")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // ФИЛЬТРАЦИЯ ПО ВИДУ (Search by Species)
    public List<Animal> getAnimalsBySpecies(String speciesName) {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT * FROM animals WHERE LOWER(species) = LOWER(?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, speciesName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Animal(rs.getString("name"), rs.getString("species"), rs.getString("animal_type"), rs.getInt("age")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void updateAnimalAge(String name, int newAge) {
        String sql = "UPDATE animals SET age = ? WHERE name = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteAnimal(String name) {
        String sql = "DELETE FROM animals WHERE name = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}