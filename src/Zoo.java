import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {
    private String city;
    private List<Animal> animals; // Наш Data Pool

    public Zoo(String city) {
        this.city = city;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal a) {
        animals.add(a);
    }

    public void sortByAge() {
        animals.sort(Comparator.comparingInt(Animal::getAge));
    }

    public void printOnlyTigers() {
        System.out.println("\n--- Searching for Tigers in " + city + " ---");
        for (Animal a : animals) {
            if (a.getSpecies().equalsIgnoreCase("Tiger")) {
                System.out.println(a);
            }
        }
    }

    public void printAll() {
        System.out.println("\nAll animals in " + city + ":");
        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}