package abstract_fabric.fabric;

import abstract_fabric.model.Chair;
import abstract_fabric.model.Sofa;
import abstract_fabric.model.Table;

public interface FurnitureFabric {
    Chair getChair();
    Sofa getSofa();
    Table getTable();
}
