package menu.acties.adminActies;

import coaData.Land;
import managers.LandManager;
import menu.MenuActie;
import scanner.ClosedQuestion;

public class ActieVerwijderLand extends MenuActie {
    public ActieVerwijderLand(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        LandManager landManager = LandManager.getInstance();
        Land land = landManager.actiefLand;

        if (ClosedQuestion.question("Weet u zeker dat u " + land.getNaam() + " wilt verwijderen?")) {
            landManager.alleLanden.remove(land);
            System.out.println(land.getNaam() + " verwijderd.");
        }
        else {
            System.out.println("Verwijderen geannuleerd");
        }
    }
}
