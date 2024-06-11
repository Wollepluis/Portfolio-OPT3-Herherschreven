package coaData;

import events.EventHandler;
import events.VluchtelingEventArgs;

import java.util.ArrayList;

public class AZC extends Verblijfplaats {

    private int aantalPlaatsen;
    private final ArrayList<Vluchteling> gevestigdeVluchtelingen = new ArrayList<>();
    public EventHandler vluchtelingAdded = new EventHandler();

    public int getAantalPlaatsen() {
        return this.aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public ArrayList<Vluchteling> getGevestigdeVluchtelingen() {
        return this.gevestigdeVluchtelingen;
    }

    public void addVluchteling(Vluchteling vluchteling) {
        this.gevestigdeVluchtelingen.add(vluchteling);
        vluchtelingAdded.invoke(this, new VluchtelingEventArgs(vluchteling));
    }

    public int getBeschikbarePlaatsen() {
        return aantalPlaatsen - gevestigdeVluchtelingen.size();
    }
    public static Adres vraagNaarAZCAdres() {
        while (true) {
            System.out.println("Geef adres op.");
            Adres adres = getAZCAdres(vraagPostcode(), vraagStraatnaam(), vraagHuisnummer());

            if (adres != null) {
                return adres;
            }
            System.out.println("Dit adres staat niet in het systeem.");
        }
    }

    public static Adres getAZCAdres(String postcode, String straatnaam, int huisnummer) {

        for (Adres a : alleAZCs) {

            if (postcode.equalsIgnoreCase(a.getPostcode()) && straatnaam.equalsIgnoreCase(a.getStraatnaam()) && huisnummer == a.getHuisnummer()) {
                return a;
            }
        }
        return null;
    }


    public AZC(Adres adres, int aantalPlaatsen) {
        super(adres);
        setAantalPlaatsen(aantalPlaatsen);
    }
}
