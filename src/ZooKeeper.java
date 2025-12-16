public class ZooKeeper {
    String name;
    String gender;
    int age;
    public ZooKeeper(String name, String gender, int age) {
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public  String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String species) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void info() {
        System.out.println(name + " " + gender + " " + age);
    }
}

