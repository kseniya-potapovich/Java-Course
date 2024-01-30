package abstract_fabric.fabric;

import abstract_fabric.model.Chair;
import abstract_fabric.model.Sofa;
import abstract_fabric.model.Table;
import abstract_fabric.model.WoodChair;
import abstract_fabric.model.WoodSofa;
import abstract_fabric.model.WoodTable;

public class WoodFurnitureFabric implements FurnitureFabric{
    @Override
    public Chair getChair() {
        return new WoodChair();
    }

    @Override
    public Sofa getSofa() {
        return new WoodSofa();
    }

    @Override
    public Table getTable() {
        return new WoodTable();
    }
}
