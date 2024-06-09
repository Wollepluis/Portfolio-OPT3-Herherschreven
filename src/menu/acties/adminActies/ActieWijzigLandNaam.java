package menu.acties.adminActies;

import coaData.Land;
import menu.MenuActie;
import menu.MenuScherm;
import scanner.MyScanner;

public class ActieWijzigLandNaam extends MenuActie {
    public ActieWijzigLandNaam(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        System.out.print("Nieuwe naam: ");
        Land.actiefLand.setNaam(MyScanner.nextLine());
        System.out.println("Naam gewijzigd.");
    }
}
