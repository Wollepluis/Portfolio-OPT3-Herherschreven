package menu.acties.adminActies;

import coaData.Gemeente;
import managers.GemeenteManager;
import menu.IActie;
import scanner.MyScanner;

public class ActieVoegGemeenteToe implements IActie {

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();

        while (true) {
            System.out.println("Geef de naam van de gemeente op: ");
            String gemeenteNaam = MyScanner.nextLine();

            Gemeente gemeente = gemeenteManager.getGemeente(gemeenteNaam);

            if (gemeente == null) {
                System.out.print("Geeft het aantal inwoners in deze gemeente op: ");
                int aantalInwoners = MyScanner.nextInt(0);

                gemeenteManager.alleGemeentes.add(new Gemeente(gemeenteNaam, aantalInwoners));
                System.out.println("Gemeente toegevoegd.");
                break;
            }
            System.out.println("Deze gemeente bestaat al.");
        }
    }
}
