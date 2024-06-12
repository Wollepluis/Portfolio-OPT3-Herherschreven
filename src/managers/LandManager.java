package managers;

import coaData.Land;
import scanner.MyScanner;

import java.util.ArrayList;

public class LandManager {
    private static LandManager instance;
    public final ArrayList<Land> alleLanden;
    public Land actiefLand;


    public static LandManager getInstance() {

        if (instance == null) {

            instance = new LandManager();
        }
        return instance;
    }


    public void setActiefLand(Land land) {
        this.actiefLand = land;
    }


    private LandManager() {
        this.alleLanden = new ArrayList<>();
        this.setActiefLand(null);
    }


    public Land getLand(String landnaam) {

        for (Land l : alleLanden) {

            if (landnaam.equalsIgnoreCase(l.getNaam())) {
                return l;
            }
        }
        return null;
    }


    public void voegLandToe(Land land) {
        this.alleLanden.add(land);
    }
}
