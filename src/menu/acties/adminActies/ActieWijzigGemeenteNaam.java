package menu.acties.adminActies;

import coaData.Gemeente;
import managers.GemeenteManager;
import menu.IActie;
import scanner.MyScanner;

public class ActieWijzigGemeenteNaam implements IActie {

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        Gemeente gemeente = gemeenteManager.actiefGemeente;

        while (true) {
            System.out.print("Geef nieuwe naam op: ");
            String nieuweNaam = MyScanner.nextLine();

            if (gemeenteManager.getGemeente(nieuweNaam) == null) {
                gemeente.setNaam(nieuweNaam);
                System.out.println("Naam gewijzigd.");
                break;
            }
            System.out.println("Deze gemeente bestaat al.");
        }
    }
}
