package menu;

import coaData.*;
import enums.PreMenuType;
import managers.*;
import scanner.MyScanner;

import java.util.ArrayList;

public class Menu {

    private final MenuScherm menuScherm;
    private final ArrayList<Menukeuze> menukeuzes = new ArrayList<>();

    LandManager landManager = LandManager.getInstance();
    VluchtelingManager vluchtelingManager = VluchtelingManager.getInstance();
    GemeenteManager gemeenteManager = GemeenteManager.getInstance();
    VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();

    public Menu(MenuScherm menuScherm) {
        this.menuScherm = menuScherm;
    }

    public void toonMenukeuze() {

        int index = 0;
        for (Menukeuze m : menukeuzes) {
            System.out.println("[" + index++ + "]" + m.getNaam());
        }
    }

    public void vraagNaarLand() {

        while (true) {
            System.out.print("Land: ");
            Land land = landManager.getLand(MyScanner.nextLine());

            if (land != null) {
                landManager.setActiefLand(land);
                break;
            }
            System.out.println("Dit land staat niet in het systeem.");
        }
    }


    public void vraagNaarGemeente() {

        while (true) {
            System.out.print("Gemeente: ");
            Gemeente gemeente = gemeenteManager.getGemeente(MyScanner.nextLine());

            if (gemeente != null) {
                gemeenteManager.setActiefGemeente(gemeente);
                break;
            }
            System.out.println("Deze gemeente staat niet in het systeem.");
        }
    }


    public void vraagNaarVluchteling() {

        while (true) {
            System.out.print("Naam: ");
            Vluchteling vluchteling = vluchtelingManager.getVluchteling(MyScanner.nextLine());

            if (vluchteling != null) {
                vluchtelingManager.setActiefVluchteling(vluchteling);
                break;
            }
            System.out.println("Deze vluchteling staat niet in het systeem.");
        }
    }


    public void vraagNaarVerblijfplaats() {

        while (true) {
            System.out.println("Geef adres op.");
            System.out.print("Postcode: ");
            String postcode = MyScanner.nextLine();
            System.out.print("Straatnaam: ");
            String straatnaam = MyScanner.nextLine();
            System.out.print("Huisnummer: ");
            int huisnummer = MyScanner.nextInt(0);

            Verblijfplaats verblijfplaats = verblijfplaatsManager.getVerblijfplaats(postcode, straatnaam, huisnummer);

            if (verblijfplaats instanceof AZC) {
                verblijfplaatsManager.setActiefAZC((AZC) verblijfplaats);
                break;
            }
            else if (verblijfplaats instanceof Woning) {
                verblijfplaatsManager.setActiefWoning((Woning) verblijfplaats);
                break;
            }
            System.out.println("Dit adres staat niet in het systeem.");
        }
    }


    public void toonPreMenu(PreMenuType preMenuType) {

        switch (preMenuType) {
            case LAND:
                vraagNaarLand();
                break;
            case GEMEENTE:
                vraagNaarGemeente();
                break;
            case NAAM:
                vraagNaarVluchteling();
                break;
            case AZC, WONING:
                vraagNaarVerblijfplaats();
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