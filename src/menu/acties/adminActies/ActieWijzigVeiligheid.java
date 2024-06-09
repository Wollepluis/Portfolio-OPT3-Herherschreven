package menu.acties.adminActies;

import coaData.Land;
import menu.MenuActie;
import scanner.ClosedQuestion;

public class ActieWijzigVeiligheid extends MenuActie {
    public ActieWijzigVeiligheid(String naam) {
        super(naam);
    }

    @Override
    public void execute() {

        if (ClosedQuestion.question("Wilt u de veiligheid van " + Land.actiefLand.getNaam() + " wijzigen?")) {
            Land.actiefLand.switchIsVeilig();
            System.out.println("Veiligheid gewijzigd");
        }
        else {
            System.out.println("Cancelled");
        }
    }
}
