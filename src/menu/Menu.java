package menu;

import scanner.MyScanner;
import java.util.ArrayList;

public class Menu {
    String titel;
    private final ArrayList<Menukeuze> menukeuzes;

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public ArrayList<Menukeuze> getMenuActies() {
        return this.menukeuzes;
    }

    public void voegMenukeuzeToe(Menukeuze menukeuze) {
        this.menukeuzes.add(menukeuze);
    }

    public Menu(String titel) {
        this.setTitel(titel);
        this.menukeuzes = new ArrayList<>();
    }

    private void printTitel() {
        System.out.printf("==== %s\n", this.titel);
    }

    private void toonMenukeuzes() {
        int index = 1;

        for (Menukeuze menukeuze : menukeuzes) {
            System.out.printf("[%d] %s\n", index++, menukeuze.getTitel());
        }
        if (this instanceof SubMenu) {
            System.out.println("\n[0] terug");
        }
        else {
            System.out.println("\n[0] exit");
        }
    }

    public void toonMenu() {
        int keuze;

        while(true) {
            printTitel();
            toonMenukeuzes();

            System.out.print("\nKeuze: ");
            keuze = MyScanner.nextInt(0, menukeuzes.size());

            if (keuze == 0) {
                if (this instanceof SubMenu) {
                    break;
                }
                else {
                    System.exit(0);
                }
            }
            else {
                menukeuzes.get(keuze - 1).getActie().execute();
            }
        }
    }
}