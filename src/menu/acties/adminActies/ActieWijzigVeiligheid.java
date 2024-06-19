package menu.acties.adminActies;

import coaData.Land;
import managers.LandManager;
import menu.IActie;
import scanner.ClosedQuestion;

public class ActieWijzigVeiligheid implements IActie {

    @Override
    public void execute() {
        LandManager landManager = LandManager.getInstance();
        Land land = landManager.actiefLand;

        if (ClosedQuestion.question("Wilt u de veiligheid van " + land.getNaam() + " wijzigen?")) {
            land.switchIsVeilig();
            System.out.println("Veiligheid van " + land.getNaam() + " gewijzigd.");
        }
        else {
            System.out.println(land.getNaam() + " niet gewijzigd.");
        }
    }
}
