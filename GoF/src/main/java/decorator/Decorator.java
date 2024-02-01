package decorator;

public class Decorator implements Developer {
    private final Developer developer;

    public Decorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void develop() {
        developer.develop();
    }
}
