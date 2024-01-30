package abstract_fabric.fabric;

import abstract_fabric.model.Chair;
import abstract_fabric.model.MetalChair;
import abstract_fabric.model.MetalSofa;
import abstract_fabric.model.MetalTable;
import abstract_fabric.model.Sofa;
import abstract_fabric.model.Table;

public class MetalFurnitureFabric implements FurnitureFabric{
    @Override
    public Chair getChair() {
        return new MetalChair();
    }

    @Override
    public Sofa getSofa() {
        return new MetalSofa();
    }

    @Override
    public Table getTable() {
        return new MetalTable();
    }
}
