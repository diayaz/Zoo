public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Zoo myZoo = new Zoo("Astana");


        db.deleteAllAnimals();
        db.addAnimal(new Animal("Arnold", "Bear", "Wild", 24));
        db.addAnimal(new Animal("Boris", "Tiger", "Wild", 30));
        db.addAnimal(new Animal("Stas", "Tiger", "Wild", 5));


        db.deleteAllZooKeepers();
        db.addZooKeeper(new ZooKeeper("John", "Male", 35));
        db.addZooKeeper(new ZooKeeper("Anna", "Female", 28));

        myZoo.setAnimals(db.getAllAnimals());

        System.out.println("\n--- DATABASE DATA LOADED ---");
        myZoo.printAll();
        myZoo.sortByAge();
        myZoo.printOnlyTigers();

        System.out.println("\nStaff info:");
    }
}