package menu.acties.adminActies;

import coaData.Land;
import managers.LandManager;
import menu.IActie;
import scanner.MyScanner;

public class ActieWijzigLandNaam implements IActie {

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
