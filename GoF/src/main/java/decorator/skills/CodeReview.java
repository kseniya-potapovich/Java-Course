package decorator.skills;

import decorator.Decorator;
import decorator.Developer;

public class CodeReview extends Decorator {
    public CodeReview(Developer developer) {
        super(developer);
    }

    @Override
    public void develop() {
        super.develop();
        System.out.println("I can do code review");
    }
}
