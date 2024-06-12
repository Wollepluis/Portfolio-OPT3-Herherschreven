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

    /**
     * Wanneer er een vluchteling wordt toegevoegd wordt het specifieke AZC - waaraan de vluchteling is toegevoegd -
     * meegegeven als sender met desbetreffende vluchteling-object.
     */
    public void voegVluchtelingToe(Vluchteling vluchteling) {
        this.gevestigdeVluchtelingen.add(vluchteling);
        vluchtelingAdded.invoke(this, new VluchtelingEventArgs(vluchteling));
    }

    public int getBeschikbarePlaatsen() {
        return aantalPlaatsen - gevestigdeVluchtelingen.size();
    }

    public AZC(Adres adres, int aantalPlaatsen) {
        super(adres);
        setAantalPlaatsen(aantalPlaatsen);
    }
}
