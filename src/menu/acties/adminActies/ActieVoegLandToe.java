package menu.acties.adminActies;

import coaData.Land;
import menu.MenuActie;
import scanner.ClosedQuestion;
import scanner.MyScanner;

public class ActieVoegLandToe extends MenuActie {

    public ActieVoegLandToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        super.execute();

        System.out.print("Geef de naam van het land op: ");
        String landNaam = MyScanner.nextLine();
        boolean isVeilig = ClosedQuestion.question("Is het land veilig?");

        Land.getAlleLanden().add(new Land(landNaam, isVeilig));
        System.out.println("Land toegevoegd.");
    }
}
