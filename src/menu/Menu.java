package menu;

import coaData.Gemeente;
import coaData.Land;
import coaData.Vluchteling;
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
                MyScanner.nextLand();
                break;
            case GEMEENTE:
                MyScanner.nextGemeente();
                break;
            case NAAM:
                MyScanner.NextVluchteling();
                break;
            case ADRES:
                MyScanner.nextAdres();
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