package proxy.my;

public class Main {
    public static void main(String[] args) {
        Project example1 = new RealProject("https://refactoring.guru/design-patterns/proxy/java/example");
        example1.run();

        Project example2 = new ProxyProject("https://refactoring.guru/design-patterns/proxy/java/example");
        example2.run();
    }
}
