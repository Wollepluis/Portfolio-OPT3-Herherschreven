package menu.acties;

import menu.MenuActie;

public class Actie2 extends MenuActie {

    public Actie2(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("Nu gebeurt de tweede Actie");
    }
}
