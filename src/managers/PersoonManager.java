package managers;

import coaData.Persoon;
import coaData.Vluchteling;

import java.util.ArrayList;

public class PersoonManager {

    private static PersoonManager instance;
    public final ArrayList<Persoon> allePersonen;
    public Persoon actiefPersoon;

    public static PersoonManager getInstance() {

        if (instance == null) {

            instance = new PersoonManager();
        }
        return instance;
    }

    private PersoonManager() {
        this.allePersonen = new ArrayList<>();
        this.setActiefPersoon(null);
    }

    public void setActiefPersoon(Vluchteling vluchteling) {
        this.actiefPersoon = vluchteling;
    }

    public Vluchteling getVluchteling(String vluchtelingNaam) {

        for (Persoon persoon : allePersonen) {

            if (persoon instanceof Vluchteling vluchteling) {

                if (vluchtelingNaam.equalsIgnoreCase(vluchteling.getNaam())) {
                    return vluchteling;
                }
            }
        }
        return null;
    }
}
