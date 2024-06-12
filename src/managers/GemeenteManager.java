package managers;

import coaData.Gemeente;

import java.util.ArrayList;

public class GemeenteManager {

    private static GemeenteManager instance;
    public final ArrayList<Gemeente> alleGemeentes;
    public Gemeente actiefGemeente;

    public static GemeenteManager getInstance() {

        if (instance == null) {

            instance = new GemeenteManager();
        }
        return instance;
    }

    public void setActiefGemeente(Gemeente gemeente) {
        this.actiefGemeente = gemeente;
    }

    private GemeenteManager() {
        this.alleGemeentes = new ArrayList<>();
        this.setActiefGemeente(null);
    }

    public Gemeente getGemeente(String gemeentenaam) {

        for (Gemeente g : alleGemeentes) {

            if (gemeentenaam.equalsIgnoreCase(g.getNaam())) {
                return g;
            }
        }
        return null;
    }
}
