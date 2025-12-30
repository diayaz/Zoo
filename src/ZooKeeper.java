public class ZooKeeper extends Creature {
    private String gender;

    public ZooKeeper(String name, String gender, int age) {
        super(name, age);
        this.gender = gender;
    }

    public String getGender() { return gender; }

    @Override
    public String toString() {
        return super.toString() + " | Gender: " + gender;
    }
}
