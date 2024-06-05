package menu;

import scanner.MyScanner;

import java.util.ArrayList;

public class Menu {

    private final MenuScherm menuScherm;
    private final ArrayList<Menukeuze> menukeuzes= new ArrayList<>();

    public Menu(MenuScherm menuScherm) {
        this.menuScherm = menuScherm;
    }

    public boolean checkValideKeuze(int keuze) {

        if (keuze > menukeuzes.size() - 1 || keuze < 0) {
            System.out.print("ERROR | Keuze: ");
            return false;
        }
        return true;
    }

    public void toonMenukeuze() {

        int index = 0;
        for (Menukeuze m : menukeuzes) {
            System.out.println("[" + index++ + "]" + m.naam);
        }
    }

    public void toonMenu() {

        int keuze;
        boolean keuzeGemaakt = false;
        boolean firstLoop = true;

        while (!keuzeGemaakt) {

            toonMenukeuze();

            if (firstLoop) {
                System.out.println();
                System.out.println("Keuze: ");
            }
            keuze = MyScanner.nextInt();

            keuzeGemaakt = checkValideKeuze(keuze);
            firstLoop = false;

            if (keuzeGemaakt) {
                menukeuzes.get(keuze).execute();
                menuScherm.printTitel();
                keuzeGemaakt = false;
                firstLoop = true;
            }
        }
    }

    public void voegKeuzeToe(Menukeuze menukeuze) {
        menukeuzes.add(menukeuze);
    }
}