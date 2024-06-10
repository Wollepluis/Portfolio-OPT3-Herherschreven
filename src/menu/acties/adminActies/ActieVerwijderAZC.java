package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Gemeente;
import menu.MenuActie;
import scanner.ClosedQuestion;

public class ActieVerwijderAZC extends MenuActie {
    public ActieVerwijderAZC(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Adres adres = Adres.actiefAdres;
        Gemeente gemeente = Gemeente.actiefGemeente;

        if (ClosedQuestion.question("Weet u zeker dat u dit AZC wilt verwijderen?")) {

            for (AZC azc : gemeente.getLocaleAZCs()) {

                if (azc.getAdres() == adres) {
                    Adres.alleAdressen.remove(adres);
                    gemeente.getLocaleAZCs().remove(azc);
                    System.out.println("AZC verwijderd.");
                    return;
                }
            }
            System.out.println("Geen AZC gevonden op dit adres.");
        }
    }
}
