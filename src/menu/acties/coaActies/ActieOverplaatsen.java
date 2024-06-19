package menu.acties.coaActies;

import managers.VerblijfplaatsManager;
import menu.IActie;

public class ActieOverplaatsen implements IActie {

    @Override
    public void execute() {

        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
//        verblijfplaatsManager.verhuis();
    }
}
