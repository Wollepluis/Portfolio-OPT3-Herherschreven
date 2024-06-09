package menu.acties.adminActies;

import coaData.Land;
import menu.MenuActie;
import scanner.ClosedQuestion;

public class ActieVerwijderLand extends MenuActie {
    public ActieVerwijderLand(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        if (ClosedQuestion.question("Weet u zeker dat u " + Land.actiefLand.getNaam() + " wilt verwijderen?")) {
            Land.alleLanden.remove(Land.actiefLand);
            System.out.println(Land.actiefLand.getNaam() + " verwijderd.");
        }
        else {
            System.out.println("Cancelled");
        }
    }
}
