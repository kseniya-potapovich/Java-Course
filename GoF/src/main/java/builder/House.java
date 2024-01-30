package builder;

/**
 * Builder - пошаговое создание сложного объекта
 * better is connect with library lombok
 */
public class House {
    private String window;
    private String door;
    private String color;
    private String roof;
    private Integer cost;

    @Override
    public String toString() {
        return "House{" +
                "window='" + window + '\'' +
                ", door='" + door + '\'' +
                ", color='" + color + '\'' +
                ", roof='" + roof + '\'' +
                ", cost=" + cost +
                '}';
    }

    public static class Builder {
        private House house;

        public Builder() {
            house = new House();
        }

        public Builder setWindow(String window) {
            house.window = window;
            return this;
        }

        public Builder setDoor(String door) {
            house.door = door;
            return this;
        }

        public Builder setColor(String color) {
            house.color = color;
            return this;
        }

        public Builder setRoof(String roof) {
            house.roof = roof;
            return this;
        }

        public Builder setCost(Integer cost) {
            house.cost = cost;
            return this;
        }

        public House build() {
            return house;
        }
    }
}
