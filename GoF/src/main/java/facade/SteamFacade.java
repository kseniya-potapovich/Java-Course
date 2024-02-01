package facade;

public class SteamFacade {
    CS2 cs2;
    Pubg pubg;

    public SteamFacade() {
        cs2 = new CS2();
        pubg = new Pubg();
    }

    public void startCsApp() {
        cs2.startApp();
    }

    public void finishCsApp() {
        cs2.finishApp();
    }

    public void startPubgApp() {
        pubg.startApp();
    }

    public void finishPubgApp() {
        pubg.finishApp();
    }
}
