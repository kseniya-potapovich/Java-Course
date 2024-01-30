package abstract_fabric.model;

import abstract_fabric.model.Table;

public class MetalTable implements Table {
    @Override
    public String getMaterial() {
        return "metal";
    }
}
