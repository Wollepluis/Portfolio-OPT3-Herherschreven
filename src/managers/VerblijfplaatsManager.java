package managers;

import coaData.*;

import java.util.ArrayList;

public class VerblijfplaatsManager {

    private static VerblijfplaatsManager instance;
    public final ArrayList<Verblijfplaats> alleVerblijfplaatsen;
    public AZC actiefAZC;
    public Woning actiefWoning;

    public static VerblijfplaatsManager getInstance() {

        if (instance == null) {

            instance = new VerblijfplaatsManager();
        }
        return instance;
    }

    public void setActiefAZC(AZC actiefAZC) {
        this.actiefAZC = actiefAZC;
    }

    public void resetActiefVerblijfplaats() {
        actiefAZC = null;
        actiefWoning = null;
    }

    public void setActiefWoning(Woning actiefWoning) {
        this.actiefWoning = actiefWoning;
    }


    private VerblijfplaatsManager() {
        this.alleVerblijfplaatsen = new ArrayList<>();
        this.setActiefAZC(null);
    }

    public Verblijfplaats getVerblijfplaats(String postcode, String straatnaam, int huisnummer) {

        for (Verblijfplaats v : alleVerblijfplaatsen) {

            if (v.getAdres().getPostcode().equalsIgnoreCase(postcode) && v.getAdres().getStraatnaam().equalsIgnoreCase(straatnaam) && v.getAdres().getHuisnummer() == huisnummer) {
                return v;
            }
        }
        return null;
    }
}
