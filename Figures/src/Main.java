public class Main {
    public static void main(String[] args) {
        //Triangle triangle = new Triangle(3, 4, 5);
        //Rectangle rectangle = new Rectangle(5, 8);
        //Circle circle = new Circle(6);

        /*System.out.println("Треугольник:");
        triangle.square();
        triangle.perimeter();

        System.out.println("Прямоугольник:");
        rectangle.square();
        rectangle.perimeter();

        System.out.println("Круг:");
        circle.square();
        circle.perimeter();*/

        double sum = 0;
        Figure[] figures = new Figure[5];
        figures[0] = new Rectangle(3, 6);
        figures[1] = new Triangle(3, 4, 5);
        figures[2] = new Circle(3);
        figures[3] = new Circle(4);
        figures[4] = new Rectangle(4, 2);
        for (int i = 0; i < figures.length; i++) {
            sum += figures[i].perimeter();
        }
        System.out.println(sum);
    }
}
