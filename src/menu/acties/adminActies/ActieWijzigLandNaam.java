package menu.acties.adminActies;

import coaData.Gemeente;
import coaData.Land;
import managers.GemeenteManager;
import managers.LandManager;
import menu.MenuActie;
import menu.MenuScherm;
import scanner.MyScanner;

public class ActieWijzigLandNaam extends MenuActie {
    public ActieWijzigLandNaam(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        LandManager landManager = LandManager.getInstance();
        Land land = landManager.actiefLand;

        while (true) {
            System.out.print("Geef nieuwe naam op: ");
            String nieuweNaam = MyScanner.nextLine();

            if (landManager.getLand(nieuweNaam) == null) {
                land.setNaam(nieuweNaam);
                System.out.println("Naam gewijzigd.");
                break;
            }
            System.out.println("Dit land bestaat al.");
        };
    }
}
