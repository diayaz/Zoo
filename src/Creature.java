import java.util.Objects;

public abstract class Creature {
    private String name;
    private int age;

    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return age == creature.age && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}