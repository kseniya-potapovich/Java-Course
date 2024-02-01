package decorator.skills;

import decorator.Decorator;
import decorator.Developer;

public class TestDeveloper extends Decorator {
    public TestDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void develop() {
        super.develop();
        System.out.println("And I can write tests!");
    }
}
