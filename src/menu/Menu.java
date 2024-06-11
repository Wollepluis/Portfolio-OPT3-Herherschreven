package menu;

import coaData.*;
import enums.PreMenuType;
import scanner.MyScanner;

import java.util.ArrayList;

public class Menu {

    private final MenuScherm menuScherm;
    private final ArrayList<Menukeuze> menukeuzes = new ArrayList<>();

    public Menu(MenuScherm menuScherm) {
        this.menuScherm = menuScherm;
    }

    public void toonMenukeuze() {

        int index = 0;
        for (Menukeuze m : menukeuzes) {
            System.out.println("[" + index++ + "]" + m.getNaam());
        }
    }

    public void toonPreMenu(PreMenuType preMenuType) {

        switch (preMenuType) {
            case LAND:
                Land.setActiefLand(Land.vraagNaarLand());
                break;
            case GEMEENTE:
                Gemeente.setActiefGemeente(Gemeente.vraagNaarGemeente());
                break;
            case NAAM:
                Vluchteling.setActiefVluchteling(Vluchteling.vraagNaarVluchteling());
                break;
            case AZC:
                Adres.setActiefAdres(AZC.vraagNaarAZCAdres());
                break;
            case WONING:
                Adres.setActiefAdres(Woning.vraagNaarWoningAdres());
                break;
        }
    }

    public void toonMenu() {

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {

            toonMenukeuze();

            System.out.println();
            System.out.print("Keuze: ");

            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            menukeuzes.get(keuze).execute();
            menuScherm.printTitel();
        }
    }

    public void voegKeuzeToe(Menukeuze menukeuze) {
        menukeuzes.add(menukeuze);
    }
}