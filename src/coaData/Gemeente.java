package coaData;

import java.util.ArrayList;

public class Gemeente {

    private String naam;
    private int aantalInwoners;
    private final ArrayList<AZC> localeAZCs;


    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalInwoners() {
        return this.aantalInwoners;
    }

    public void setAantalInwoners(int aantalInwoners) {
        this.aantalInwoners = aantalInwoners;
    }

    public ArrayList<AZC> getLocaleAZCs() {
        return localeAZCs;
    }

    public Gemeente(String naam, int aantalInwoners) {
        setNaam(naam);
        setAantalInwoners(aantalInwoners);
        this.localeAZCs = new ArrayList<>();
    }

    public AZC getLokaalAZC(String postcode, String straatnaam, int huisnummer) {

        for (AZC a : localeAZCs) {

            if (a.getAdres().getPostcode().equalsIgnoreCase(postcode) && a.getAdres().getStraatnaam().equalsIgnoreCase(straatnaam) && a.getAdres().getHuisnummer() == huisnummer) {
                return a;
            }
        }
        return null;
    }

    public int getTotaalcapaciteit() {
        int totaalCapaciteit = 0;

        for (AZC azc : localeAZCs) {
            totaalCapaciteit += azc.getAantalPlaatsen();
        }
        return totaalCapaciteit;
    }
}
