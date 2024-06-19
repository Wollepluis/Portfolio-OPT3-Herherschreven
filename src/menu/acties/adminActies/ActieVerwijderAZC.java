package menu.acties.adminActies;

import coaData.AZC;
import coaData.Gemeente;
import managers.GemeenteManager;
import managers.VerblijfplaatsManager;
import menu.IActie;
import scanner.ClosedQuestion;

public class ActieVerwijderAZC implements IActie {

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        Gemeente gemeente = gemeenteManager.actiefGemeente;
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
        AZC azc = verblijfplaatsManager.actiefAZC;

        if (ClosedQuestion.question("Weet u zeker dat u dit AZC wilt verwijderen?")) {

            if (azc.getGevestigdeVluchtelingen().isEmpty()) {

                gemeente.getLocaleAZCs().remove(verblijfplaatsManager.actiefAZC);
                verblijfplaatsManager.alleAZCs.remove(verblijfplaatsManager.actiefAZC);

                System.out.println("AZC verwijderd.");
            }
            else {

                System.out.println("Er zijn nog vluchtelingen gevestigd in dit AZC.");
                System.out.println("Verwijderen geannuleerd");
            }
        }
    }
}
