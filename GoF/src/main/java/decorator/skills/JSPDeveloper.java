package decorator.skills;

import decorator.Decorator;
import decorator.Developer;

public class JSPDeveloper extends Decorator {
    public JSPDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void develop() {
        super.develop();
        System.out.println("I am frontendier");
    }
}
