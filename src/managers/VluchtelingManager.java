package managers;

import coaData.Vluchteling;
import scanner.MyScanner;

import java.util.ArrayList;

public class VluchtelingManager {

    private static VluchtelingManager instance;
    public final ArrayList<Vluchteling> alleVluchtelingen;
    public Vluchteling actiefVluchteling;


    public static VluchtelingManager getInstance() {

        if (instance == null) {

            instance = new VluchtelingManager();
        }
        return instance;
    }


    public void setActiefVluchteling(Vluchteling vluchteling) {
        this.actiefVluchteling = vluchteling;
    }


    private VluchtelingManager() {
        this.alleVluchtelingen = new ArrayList<>();
        this.setActiefVluchteling(null);
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
