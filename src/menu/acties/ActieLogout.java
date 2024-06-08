package menu.acties;

import account.Beveiliging;
import menu.MenuActie;

public class ActieLogout extends MenuActie {

    public ActieLogout(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Beveiliging.getInstance().logout();
        Beveiliging.getInstance().login();
    }
}
