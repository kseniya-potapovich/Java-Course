package OCP;

public class Rectangle implements Shapes {
    private double width;
    private double length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public double square() {
        return width * length;
    }
}
