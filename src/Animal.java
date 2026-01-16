public class Animal extends Creature {
    private String species;
    private String type;

    public Animal(String name, String species, String type, int age) {
        super(name, age);
        this.species = species;
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " | Species: " + species + " | Type: " + type;
    }
}