package strategy;

public class Navigator {
    RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void executeStrategy() {
        routeStrategy.buildRoute();
    }
}
