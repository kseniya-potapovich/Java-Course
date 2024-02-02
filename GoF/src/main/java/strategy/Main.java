package strategy;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setRouteStrategy(new WalkingStrategy());
        navigator.executeStrategy();

        navigator.setRouteStrategy(new PublicTransportStrategy());
        navigator.executeStrategy();

        navigator.setRouteStrategy(new RoadStrategy());
        navigator.executeStrategy();
    }
}
