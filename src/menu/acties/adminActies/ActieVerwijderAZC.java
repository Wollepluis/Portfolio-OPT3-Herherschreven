package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Gemeente;
import coaData.Verblijfplaats;
import managers.GemeenteManager;
import managers.VerblijfplaatsManager;
import menu.MenuActie;
import scanner.ClosedQuestion;

public class ActieVerwijderAZC extends MenuActie {
    public ActieVerwijderAZC(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        Gemeente gemeente = gemeenteManager.actiefGemeente;
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
        AZC azc = verblijfplaatsManager.actiefAZC;

        if (ClosedQuestion.question("Weet u zeker dat u dit AZC wilt verwijderen?")) {

            if (azc.getGevestigdeVluchtelingen().isEmpty()) {

                gemeente.getLocaleAZCs().remove(verblijfplaatsManager.actiefAZC);
                verblijfplaatsManager.alleVerblijfplaatsen.remove(verblijfplaatsManager.actiefAZC);

                System.out.println("AZC verwijderd.");
            }
            else {

                System.out.println("Er zijn nog vluchtelingen gevestigd in dit AZC.");
                System.out.println("Verwijderen geannuleerd");
            }
        }
    }
}
