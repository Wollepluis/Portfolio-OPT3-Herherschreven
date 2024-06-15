package menu.acties.coaActies;

import managers.VerblijfplaatsManager;
import menu.MenuActie;

public class ActieOverplaatsen extends MenuActie {

    public ActieOverplaatsen(String naam) {
        super(naam);
    }

    @Override
    public void execute() {

        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
//        verblijfplaatsManager.verhuis();
    }
}
