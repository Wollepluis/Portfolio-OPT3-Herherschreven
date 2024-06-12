package coaData;

import events.VluchtelingEventArgs;

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

    /**
     * Wanneer er een AZC aangemaakt wordt, wordt deze direct toegevoegd aan de lijst met listeners.
     * De listener waaraan een vluchteling wordt toegevoegd krijgt een melding.
     */
    public void voegAZCToe(AZC azc) {
        localeAZCs.add(azc);

        azc.vluchtelingAdded.subscribe((sender, args) -> {

            if (args instanceof VluchtelingEventArgs vluchtelingEventArgs) {
                System.out.println("Vluchteling toegevoegd: " + vluchtelingEventArgs.getVluchteling().getNaam());
            }
        });
    }

    public void verwijderAZC(Adres adres) {
       localeAZCs.removeIf(azc -> azc.getAdres().equals(adres));
    }

    public int getTotaalcapaciteit() {
        int totaalCapaciteit = 0;

        for (AZC azc : localeAZCs) {
            totaalCapaciteit += azc.getAantalPlaatsen();
        }
        return totaalCapaciteit;
    }
}
