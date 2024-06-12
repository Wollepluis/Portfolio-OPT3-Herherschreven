package menu.acties.adminActies;

import coaData.Gemeente;
import coaData.Land;
import managers.GemeenteManager;
import managers.LandManager;
import menu.MenuActie;
import scanner.ClosedQuestion;
import scanner.MyScanner;

public class ActieVoegLandToe extends MenuActie {

    public ActieVoegLandToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        LandManager landManager = LandManager.getInstance();

        while (true) {
            System.out.print("Geef de naam van het land op: ");
            String landNaam = MyScanner.nextLine();

            Land land = landManager.getLand(landNaam);

            if (land == null) {
                boolean veilig = ClosedQuestion.question("Is dit land veilig?");

                landManager.alleLanden.add(new Land(landNaam, veilig));

                System.out.println("Land toegevoegd.");
                break;
            }
            System.out.println("Dit land bestaat al.");
        }
    }
}
