public class Human implements Cloneable {
    String name;
    int age;

    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
