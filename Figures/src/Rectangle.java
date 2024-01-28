public class Rectangle extends Figure {
    private double width;
    private double length;

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    double square() {
        return square = width * length;
        //System.out.println(square);
    }

    @Override
    double perimeter() {
        return perimeter = 2 * (width + length);
        //System.out.println(perimeter);
    }
}
