package prototype;

import java.util.Objects;

public class Car implements Prototype{
    private String color;
    private int speed;
    private String brand;

    public Car(String color, int speed, String brand) {
        this.color = color;
        this.speed = speed;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && Objects.equals(color, car.color) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, speed, brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", speed=" + speed +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public Prototype copy() {
        Car copy = new Car(color, speed, brand);
        return copy;
    }
}
