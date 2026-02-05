import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ZOO DATABASE MENU ---");
            System.out.println("1. Add Animal");
            System.out.println("2. Show All & Sort (Age/Name)");
            System.out.println("3. Search by Species (e.g. Bear)");
            System.out.println("4. Update Animal Age");
            System.out.println("5. Delete Animal");
            System.out.println("6. Exit");
            System.out.print("Action: ");

            int action = sc.nextInt();
            sc.nextLine();

            if (action == 6) break;

            switch (action) {
                case 1:
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Species: "); String s = sc.nextLine();
                    System.out.print("Type: "); String t = sc.nextLine();
                    System.out.print("Age: "); int a = sc.nextInt();
                    db.addAnimal(new Animal(n, s, t, a));
                    break;

                case 2:
                    System.out.println("Sort by: 1. Name, 2. Age");
                    int sortCol = sc.nextInt();
                    System.out.println("Direction: 1. Low to High (ASC), 2. High to Low (DESC)");
                    int sortDir = sc.nextInt();

                    String col = (sortCol == 2) ? "age" : "name";
                    String dir = (sortDir == 2) ? "DESC" : "ASC";

                    db.getAnimalsSorted(col, dir).forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter species to filter (e.g. Bear): ");
                    String spec = sc.nextLine();
                    List<Animal> filtered = db.getAnimalsBySpecies(spec);
                    if (filtered.isEmpty()) System.out.println("No such animals found.");
                    else filtered.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Animal name to update: "); String upName = sc.nextLine();
                    System.out.print("New age: "); int newAge = sc.nextInt();
                    db.updateAnimalAge(upName, newAge);
                    break;

                case 5:
                    System.out.print("Name to delete: "); String delName = sc.nextLine();
                    db.deleteAnimal(delName);
                    break;
            }
        }
        sc.close();
    }
}