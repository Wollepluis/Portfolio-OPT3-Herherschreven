package managers;

import coaData.*;

import java.util.ArrayList;

public class VerblijfplaatsManager {

    private static VerblijfplaatsManager instance;
    public final ArrayList<AZC> alleAZCs;
    public final ArrayList<Woning> alleWoningen;
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
        this.alleAZCs = new ArrayList<>();
        this.alleWoningen = new ArrayList<>();
        this.setActiefAZC(null);
    }

    public AZC getAZC(String postcode, String straatnaam, int huisnummer) {

        for (AZC azc : alleAZCs) {

            if (azc.getAdres().getPostcode().equalsIgnoreCase(postcode) && azc.getAdres().getStraatnaam().equalsIgnoreCase(straatnaam) && azc.getAdres().getHuisnummer() == huisnummer) {
                return azc;
            }
        }
        return null;
    }

    public Woning getWoning(String postcode, String straatnaam, int huisnummer) {

        for (Woning woning : alleWoningen) {

            if (woning.getAdres().getPostcode().equalsIgnoreCase(postcode) && woning.getAdres().getStraatnaam().equalsIgnoreCase(straatnaam) && woning.getAdres().getHuisnummer() == huisnummer) {
                return woning;
            }
        }
        return null;
    }
}
