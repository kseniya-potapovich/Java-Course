package task15_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(13);
        myArrayList.add(0,3);
        myArrayList.add(23);
        myArrayList.add(11);
        myArrayList.add(67);
        System.out.println(myArrayList);
        myArrayList.remove(1);
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(2));
        System.out.println(myArrayList.contains(3));
        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
