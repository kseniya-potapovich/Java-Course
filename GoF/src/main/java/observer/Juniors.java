package observer;

import java.util.List;

public class Juniors implements Observer {
    private String name;

    public Juniors(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " + name + "\nwe have changes in vacancies\n" + vacancies
                + "\n***************************\n");
    }
}
