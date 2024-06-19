package managers;

import coaData.*;
import events.VluchtelingEventArgs;

import java.util.ArrayList;

public class VerblijfplaatsManager {

    private static VerblijfplaatsManager instance;
    public final ArrayList<Verblijfplaats> alleVerblijfplaatsen;
    public Verblijfplaats actiefVerblijfplaats;


    public static VerblijfplaatsManager getInstance() {

        if (instance == null) {

            instance = new VerblijfplaatsManager();
        }
        return instance;
    }

    private VerblijfplaatsManager() {
        this.alleVerblijfplaatsen = new ArrayList<>();
    }

    /**
     * Wanneer er een AZC aangemaakt wordt, wordt deze direct toegevoegd aan de lijst met listeners.
     * De listener waaraan een vluchteling wordt toegevoegd krijgt een melding.
     */
     public void voegVerblijfplaatsToe(Verblijfplaats verblijfplaats) {

        if (verblijfplaats instanceof AZC azc) {
            verblijfplaats.getAdres().getGemeente().getLocaleAZCs().add(azc);

            azc.vluchtelingAdded.subscribe((sender, args) -> {

                if (args instanceof VluchtelingEventArgs vluchtelingEventArgs) {
                    System.out.println("Vluchteling toegevoegd: " + vluchtelingEventArgs.getVluchteling().getNaam());
                }
            });
        }
        this.alleVerblijfplaatsen.add(verblijfplaats);
     }

     public void verwijderAZC() {
         actiefVerblijfplaats.getAdres().getGemeente().getLocaleAZCs().remove(actiefVerblijfplaats);
         alleVerblijfplaatsen.remove(actiefVerblijfplaats);
     }
}
