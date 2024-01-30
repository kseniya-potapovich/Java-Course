package abstract_fabric;

import abstract_fabric.fabric.FurnitureFabric;
import abstract_fabric.fabric.WoodFurnitureFabric;
import abstract_fabric.model.Chair;
import abstract_fabric.model.Sofa;
import abstract_fabric.model.Table;

public class Main {
    public static void main(String[] args) {
        FurnitureFabric fabric = new WoodFurnitureFabric();
        Chair chair = fabric.getChair();
        Sofa sofa = fabric.getSofa();
        Table table = fabric.getTable();

        System.out.println("Your furniture: ");
        System.out.println("Chair: " + chair.getMaterial());
        System.out.println("Sofa: " + sofa.getMaterial());
        System.out.println("Table: " + table.getMaterial());
    }
}
