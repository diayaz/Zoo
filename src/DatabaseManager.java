import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "Diasik228";

    private Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }


    public void deleteAllAnimals() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM animals");
            System.out.println("Animals table cleared.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addAnimal(Animal a) {
        String sql = "INSERT INTO animals (name, age, species, animal_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getName());
            pstmt.setInt(2, a.getAge());
            pstmt.setString(3, a.getSpecies());
            pstmt.setString(4, a.getType());
            pstmt.executeUpdate();
            System.out.println("Animal saved: " + a.getName());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Animal> getAllAnimals() {
        List<Animal> list = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM animals")) {
            while (rs.next()) {
                list.add(new Animal(rs.getString("name"), rs.getString("species"), rs.getString("animal_type"), rs.getInt("age")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }


    public void deleteAllZooKeepers() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM zookeepers");
            System.out.println("ZooKeepers table cleared.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void addZooKeeper(ZooKeeper k) {
        String sql = "INSERT INTO zookeepers (name, age, gender) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, k.getName());
            pstmt.setInt(2, k.getAge());
            pstmt.setString(3, k.getGender());
            pstmt.executeUpdate();
            System.out.println("ZooKeeper saved: " + k.getName());
        } catch (SQLException e) { e.printStackTrace(); }
    }
}