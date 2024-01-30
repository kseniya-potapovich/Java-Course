package abstract_fabric.model;

import abstract_fabric.model.Sofa;

public class MetalSofa implements Sofa {
    @Override
    public String getMaterial() {
        return "metal";
    }
}
