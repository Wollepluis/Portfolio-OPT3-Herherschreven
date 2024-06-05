package menu.acties;

import menu.MenuActie;

public class Actie1 extends MenuActie {

    public Actie1(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("Nu gebeurt de eerste Actie");
    }
}
