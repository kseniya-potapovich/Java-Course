package singleton;
/** Singleton - паттерн проектирования, который позволяет создавать только один оъект */
public class Fox {
    private static Fox fox;

    private Fox() {
    }

    public static Fox init() {
        if (fox == null) {
            fox = new Fox();
        }
        return fox;
    }
}
