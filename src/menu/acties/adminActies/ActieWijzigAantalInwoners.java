package menu.acties.adminActies;

import coaData.Gemeente;
import managers.GemeenteManager;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieWijzigAantalInwoners extends MenuActie {
    public ActieWijzigAantalInwoners(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Gemeente gemeente = GemeenteManager.getInstance().actiefGemeente;

        System.out.print("Geef het aantal inwoners op: ");
        int nieuwAantalInwoners = MyScanner.nextInt();

        gemeente.setAantalInwoners(nieuwAantalInwoners);
        System.out.println("Aantal inwoners gewijzigd.");
    }
}
