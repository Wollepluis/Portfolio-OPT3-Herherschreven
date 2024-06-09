package menu.acties.adminActies;

import coaData.Gemeente;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieVoegGemeenteToe extends MenuActie {

    public ActieVoegGemeenteToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        System.out.println("Geef de naam van de gemeente op: ");
        String gemeenteNaam = MyScanner.nextLine();
        System.out.println("Geeft het aantal inwoners in deze gemeente op: ");
        int aantalInwoners= MyScanner.nextInt();

        Gemeente.alleGemeentes.add(new Gemeente(gemeenteNaam, aantalInwoners));
        System.out.println("Gemeente toegevoegd.");
    }
}
