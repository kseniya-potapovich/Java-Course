public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human person1 = new Human("Ivan", 23);
        Human person2 = (Human) person1.clone();
        System.out.println(person1.name + " " + person1.age);
        System.out.println(person2.name + " " + person2.age);
    }
}
