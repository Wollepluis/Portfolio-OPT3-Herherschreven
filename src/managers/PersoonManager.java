package managers;

import coaData.Persoon;
import coaData.Vluchteling;

import java.util.ArrayList;

public class PersoonManager {

    private static PersoonManager instance;
    public final ArrayList<Vluchteling> alleVluchtelingen;
    public Persoon actiefPersoon;

    public static PersoonManager getInstance() {

        if (instance == null) {

            instance = new PersoonManager();
        }
        return instance;
    }

    private PersoonManager() {
        this.alleVluchtelingen = new ArrayList<>();
        this.setActiefPersoon(null);
    }

    public void setActiefPersoon(Vluchteling vluchteling) {
        this.actiefPersoon = vluchteling;
    }

    public Vluchteling getVluchteling(String vluchtelingNaam) {

        for (Vluchteling v : alleVluchtelingen) {

            if (vluchtelingNaam.equalsIgnoreCase(v.getNaam())) {
                return v;
            }
        }
        return null;
    }
}
