package coaData;

import events.EventArgs;
import events.IEventListener;
import events.VluchtelingEventArgs;

import java.util.ArrayList;

public class Gemeente {

    private String naam;
    private int aantalInwoners;
    private final ArrayList<AZC> localeAZCs = new ArrayList<>();

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

    public void voegAZCToe(AZC azc) {
        localeAZCs.add(azc);

        azc.vluchtelingAdded.subscribe((sender, args) -> {

            if (args instanceof VluchtelingEventArgs vluchtelingEventArgs) {
                System.out.println("Vluchteling toegevoegd: " + vluchtelingEventArgs.getVluchteling());
            }
        });
    }

    public void verwijderAZC(Adres adres) {
        localeAZCs.removeIf(azc -> azc.getAdres().equals(adres));
    }

    public Gemeente(String naam, int aantalInwoners) {
        setNaam(naam);
        setAantalInwoners(aantalInwoners);
    }

    public int getTotaalcapaciteit() {

        int totaalCapaciteit = 0;
        for (AZC azc : localeAZCs) {
            totaalCapaciteit += azc.getAantalPlaatsen();
        }
        return totaalCapaciteit;
    }

    public void stelRapportageOp() {

    }
}
