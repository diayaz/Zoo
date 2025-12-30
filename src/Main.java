public class Main {
    public static void main(String[] args) {

        Zoo myZoo = new Zoo("Astana");


        myZoo.addAnimal(new Animal("Arnold", "Bear", "Wild", 24));
        myZoo.addAnimal(new Animal("Boris", "Tiger", "Wild", 30));
        myZoo.addAnimal(new Animal("Stas", "Tiger", "Wild", 5));


        myZoo.printAll();


        myZoo.sortByAge();
        System.out.println("\n(Sorted by age)");
        myZoo.printAll();


        myZoo.printOnlyTigers();


        ZooKeeper k1 = new ZooKeeper("John", "Male", 35);
        System.out.println("\nStaff info:");
        System.out.println(k1);
    }
}