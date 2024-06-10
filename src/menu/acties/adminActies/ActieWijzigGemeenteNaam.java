package menu.acties.adminActies;

import coaData.Gemeente;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieWijzigGemeenteNaam extends MenuActie {
    public ActieWijzigGemeenteNaam(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        System.out.println("Van Welke gemeente wil je de naam aanpassen?");
        Gemeente gemeente = Gemeente.vraagNaarGemeente();

        System.out.print("Geef nieuwe naam op:");
        String nieuweNaam = MyScanner.nextLine();

        gemeente.setNaam(nieuweNaam);
        System.out.println("Naam gewijzigd.");
    }
}
