public class Circle extends Figure {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double square() {
        return square = PI * radius * radius;
        //System.out.println(square);
    }

    @Override
    double perimeter() {
        return perimeter = 2 * PI * radius;
        //System.out.println(perimeter);

    }
}
