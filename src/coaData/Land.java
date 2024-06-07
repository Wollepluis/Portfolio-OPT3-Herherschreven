package coaData;

import java.util.ArrayList;

public class Land {
    private String naam;
    private boolean isVeilig;
    private static final ArrayList<Land> alleLanden = new ArrayList<>();

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

    public Land(String naam, boolean isVeilig) {
        setNaam(naam);
        setVeilig(isVeilig);
    }
}
