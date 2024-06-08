package menu;

import enums.PreMenuType;

public class MenuScherm extends Menukeuze {

    public Menu menu = new Menu(this);

    public MenuScherm(String naam) {
        super(naam);
    }

    public MenuScherm(String naam, PreMenuType preMenuType) {
        super(naam);
        menu.toonPreMenu(preMenuType);
    }

    @Override
    public void printTitel() {
        super.printTitel();
    }

    @Override
    public void execute() {
        printTitel();
        menu.toonMenu();
    }
}
