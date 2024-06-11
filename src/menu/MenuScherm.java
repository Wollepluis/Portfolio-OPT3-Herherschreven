package menu;

import enums.PreMenuType;
import coaData.*;

public class MenuScherm extends Menukeuze {

    public Menu menu = new Menu(this);
    private PreMenuType type;

    public MenuScherm(String naam) {
        super(naam);
    }

    public MenuScherm(String naam, PreMenuType preMenuType) {
        super(naam);
        this.type = preMenuType;
    }

    @Override
    public void printTitel() {
        super.printTitel();
        switch (type) {
            case LAND -> System.out.println(": " + Land.actiefLand.getNaam());
            case NAAM -> System.out.println(": " + Vluchteling.actiefVluchteling.getNaam());
            case GEMEENTE -> System.out.println(": " + Gemeente.actiefGemeente.getNaam());
            case AZC, WONING -> System.out.printf(": %s %d (%s)\n", Adres.actiefAdres.getStraatnaam(), Adres.actiefAdres.getHuisnummer(), Adres.actiefAdres.getPostcode());
            case null -> System.out.println();
        }
    }

    @Override
    public void execute() {

        if (type != null) {
            menu.toonPreMenu(type);
        }
        try {
            printTitel();
            menu.toonMenu();
        }
        catch (NullPointerException e) {
            System.out.println("\nStaat niet in het systeem");
        }
    }
}
