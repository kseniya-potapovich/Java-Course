public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double square() {
        return square = (((a + b + c) / 2) * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c));
        //System.out.println(Math.sqrt(square));
    }

    @Override
    double perimeter() {
        return perimeter = a + b + c;
        //System.out.println(perimeter);
    }
}
