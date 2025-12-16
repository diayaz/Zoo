public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("Arnold", "Bear", "Male", 24);
        Animal a2 = new Animal("Boris", "Tiger", "Male", 30);

        ZooKeeper k1 = new ZooKeeper("John", "Male", 35);
        ZooKeeper k2 = new ZooKeeper("Anna", "Female", 28);

        Zoo zoo1 = new Zoo("Astana", 25);
        Zoo zoo2 = new Zoo("Almaty", 40);

        a1.info();
        a2.info();
        k1.info();
        k2.info();
        System.out.println("Zoo city " + zoo1.getCity() + " have " + zoo1.getAnimalCount() + " animals.");
        System.out.println("Zoo city " + zoo2.getCity() + " have " + zoo2.getAnimalCount() + " animals.");

        if (a1.getAge() > a2.getAge()) {
            System.out.println(a1.getName() + " older than " + a2.getName());
        } else {
            System.out.println(a2.getName() + " older than " + a1.getName());
        }

        if (k1.getAge() > k2.getAge()) {
            System.out.println(k1.getName() + " older than " + k2.getName());
        } else {
            System.out.println(k2.getName() + " older than " + k1.getName());
        }

        if (zoo1.getAnimalCount() > zoo2.getAnimalCount()) {
            System.out.println("Zoo in " + zoo1.getCity() + " has more animals.");
        } else {
            System.out.println("Zoo in " + zoo2.getCity() + " has more animals.");
        }
    }
}
