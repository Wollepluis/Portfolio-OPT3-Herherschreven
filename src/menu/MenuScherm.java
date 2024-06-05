package menu;

public class MenuScherm extends Menukeuze {

    public Menu menu = new Menu(this);

    public MenuScherm(String naam) {
        super(naam);
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
