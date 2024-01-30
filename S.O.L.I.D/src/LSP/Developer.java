package LSP;

public class Developer extends Person {
    @Override
    public void eat() {
        System.out.println("I can eat!");
    }

    @Override
    public void think() {
        System.out.println("I can think!");
    }

    public void writeCode() {
        System.out.println("Write some code...");
    }
}
