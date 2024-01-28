package task15_2;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Stack;

public class Animals {
    private Stack<String> names;

    public Animals(Stack<String> names) {
        this.names = names;
    }

    public void addName(String name){
        names.add(name);
    }

    public void deleteName(){
        names.remove(0);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "names=" + names +
                '}';
    }
}
