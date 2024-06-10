package menu.acties.adminActies;

import coaData.Gemeente;
import menu.MenuActie;

public class ActieBeschikbarePlaatsenOpvragen extends MenuActie {
    public ActieBeschikbarePlaatsenOpvragen(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Gemeente gemeente = Gemeente.actiefGemeente;

        System.out.printf("Er zijn totaal %d plaatsen beschikbaar in %s", gemeente.getTotaalcapaciteit(), gemeente.getNaam());
    }
}
