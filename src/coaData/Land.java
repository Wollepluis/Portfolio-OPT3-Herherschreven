package coaData;

import java.util.ArrayList;

public class Land {
    private String naam;
    private boolean isVeilig;
    private static final ArrayList<Land> alleLanden = new ArrayList<>();
    public static Land actiefLand;

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isVeilig() {
        return this.isVeilig;
    }

    public void setVeilig(boolean isVeilig) {
        this.isVeilig = isVeilig;
    }

    public void switchIsVeilig() {
        this.isVeilig = !isVeilig;
    }

    public static ArrayList<Land> getAlleLanden() {
        return alleLanden;
    }

    public static Land getLand(String landnaam) {

        for (Land l : alleLanden) {

            if (landnaam.equalsIgnoreCase(l.getNaam())) {
                return l;
            }
        }
        return null;
    }

    public static void setActiefLand(Land land) {
        actiefLand = land;
    }

    public Land(String naam, boolean isVeilig) {
        setNaam(naam);
        setVeilig(isVeilig);
    }
}
