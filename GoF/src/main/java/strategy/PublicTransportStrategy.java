package strategy;

public class PublicTransportStrategy implements RouteStrategy{
    @Override
    public void buildRoute() {
        System.out.println("You can travel on the public transport...");
    }
}
