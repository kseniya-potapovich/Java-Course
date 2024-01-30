package LSP;

public class FrontEndDeveloper extends Developer{
    @Override
    public void eat() {
        System.out.println("I can eat!");
    }

    @Override
    public void think() {
        System.out.println("I can think!");
    }

    @Override
    public void writeCode() {
        System.out.println("Write some code...");
    }

    public void makeWebsite(){
        System.out.println("I can make up websites");
    }
}
