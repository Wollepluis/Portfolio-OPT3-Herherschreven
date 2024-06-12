package menu.acties.adminActies;

import coaData.AZC;
import coaData.Gemeente;
import managers.GemeenteManager;
import menu.MenuActie;

public class ActieRapportageOpvragen extends MenuActie {
    public ActieRapportageOpvragen(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();

        Gemeente gemeente = gemeenteManager.actiefGemeente;

        System.out.printf("\n==== Rapportage %s ====\n", gemeente.getNaam());
        System.out.printf("\nAantal Inwoners: %d\n", gemeente.getAantalInwoners());

        int totaalcapaciteit = 0;
        int aantalVluchtelingen = 0;

        for (AZC azc : gemeente.getLocaleAZCs()) {
            totaalcapaciteit += azc.getAantalPlaatsen();
            aantalVluchtelingen += azc.getGevestigdeVluchtelingen().size();
        }
        System.out.printf("Aantal AZCs: %d%n", gemeente.getLocaleAZCs().size());
        System.out.printf("Totale capaciteit: %d%n", totaalcapaciteit);
        System.out.printf("Aantal gevestigde vluchtelingen: %d%n", aantalVluchtelingen);

        int uitkering;
        if (totaalcapaciteit == 0) {
            uitkering = 0;
        }
        else if (totaalcapaciteit > (gemeente.getAantalInwoners() * 0.005) + 100){
            uitkering = 2000 * aantalVluchtelingen;
        }
        else {
            uitkering = 1000 * aantalVluchtelingen;
        }
        System.out.printf("Uitkering: €%d,-%n",uitkering);
        System.out.println("\n ====");
    }
}
