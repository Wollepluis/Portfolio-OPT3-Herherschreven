package menu;

import enums.PreMenuType;
import managers.*;

public class MenuScherm extends Menukeuze {

    public Menu menu = new Menu(this);
    private PreMenuType type;

    LandManager landManager = LandManager.getInstance();
    PersoonManager persoonManager = PersoonManager.getInstance();
    GemeenteManager gemeenteManager = GemeenteManager.getInstance();
    VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();

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
            case LAND -> System.out.println(": " + landManager.actiefLand.getNaam());
            case NAAM -> System.out.println(": " + persoonManager.actiefPersoon.getNaam());
            case GEMEENTE -> System.out.println(": " + gemeenteManager.actiefGemeente.getNaam());
            case AZC-> System.out.printf(": %s %d (%s)\n", verblijfplaatsManager.actiefAZC.getAdres().getStraatnaam(), verblijfplaatsManager.actiefAZC.getAdres().getHuisnummer(), verblijfplaatsManager.actiefAZC.getAdres().getPostcode());
            case WONING-> System.out.printf(": %s %d (%s)\n", verblijfplaatsManager.actiefWoning.getAdres().getStraatnaam(), verblijfplaatsManager.actiefWoning.getAdres().getHuisnummer(), verblijfplaatsManager.actiefWoning.getAdres().getPostcode());
            case null -> System.out.println();
        }
    }

    @Override
    public void execute() {

        if (type != null) {

            if (type == PreMenuType.GEMEENTE) {
                verblijfplaatsManager.resetActiefVerblijfplaats();
            }
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
