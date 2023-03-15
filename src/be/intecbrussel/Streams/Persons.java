package be.intecbrussel.Streams;

public class Persons {
    public String name;
    public int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
