package menu;

import coaData.*;
import enums.PreMenuType;
import managers.*;
import scanner.MyScanner;

import java.util.ArrayList;

public class Menu {

    private final MenuScherm menuScherm;
    private final ArrayList<Menukeuze> menukeuzes = new ArrayList<>();
    PersoonManager persoonManager = PersoonManager.getInstance();

    public Menu(MenuScherm menuScherm) {
        this.menuScherm = menuScherm;
    }

    public void toonMenukeuze() {

        int index = 0;
        for (Menukeuze m : menukeuzes) {
            System.out.println("[" + index++ + "]" + m.getNaam());
        }
    }

    public void landPreMenu() {
        LandManager landManager = LandManager.getInstance();

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {
            int index = 0;
            for (Land land : landManager.alleLanden) {
                System.out.println("[" + index++ + "]" + land.getNaam());
            }

            System.out.print("\nKeuze: ");

            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            LandManager.getInstance().setActiefLand(landManager.alleLanden.get(keuze));
            break;
        }
    }

    private void gemeentePreMenu() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {
            int index = 0;
            for (Gemeente gemeente : gemeenteManager.alleGemeentes) {
                System.out.println("[" + index++ + "]" + gemeente.getNaam());
            }

            System.out.print("\nKeuze: ");

            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            GemeenteManager.getInstance().setActiefGemeente(gemeenteManager.alleGemeentes.get(keuze));
            break;
        }
    }

    private void azcPreMenu() {
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {
            int index = 0;
            for (Verblijfplaats verblijfplaats : verblijfplaatsManager.alleAZCs) {

                index++;
                String gemeente = verblijfplaats.getAdres().getGemeente().getNaam();
                String straatnaam = verblijfplaats.getAdres().getStraatnaam();
                String postcode = verblijfplaats.getAdres().getPostcode();
                int huisnummer = verblijfplaats.getAdres().getHuisnummer();
                System.out.printf("[%d] %s: %s %d (%s)", index, gemeente, straatnaam, huisnummer, postcode);
            }

            System.out.print("\nKeuze:");
            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            VerblijfplaatsManager.getInstance().setActiefAZC(verblijfplaatsManager.alleAZCs.get(keuze));
            break;
        }
    }

    private void woningPreMenu() {
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {
            int index = 0;
            for (Verblijfplaats verblijfplaats : verblijfplaatsManager.alleWoningen) {
                index++;
                String gemeente = verblijfplaats.getAdres().getGemeente().getNaam();
                String straatnaam = verblijfplaats.getAdres().getStraatnaam();
                String postcode = verblijfplaats.getAdres().getPostcode();
                int huisnummer = verblijfplaats.getAdres().getHuisnummer();
                System.out.printf("[%d] %s: %s %d (%s)", index, gemeente, straatnaam, huisnummer, postcode);
            }

            System.out.print("\nKeuze:");
            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            VerblijfplaatsManager.getInstance().setActiefWoning(verblijfplaatsManager.alleWoningen.get(keuze));
            break;
        }
    }

    public void toonPreMenu(PreMenuType preMenuType) {
        switch (preMenuType) {
            case LAND:
                landPreMenu();
                break;
            case GEMEENTE:
                gemeentePreMenu();
                break;
            case NAAM:
                vraagNaarVluchteling();
                break;
            case AZC:
                azcPreMenu();
                break;
            case WONING:
                woningPreMenu();
                break;
        }
    }

    public void vraagNaarVluchteling() {

        while (true) {
            System.out.print("Naam: ");
            Vluchteling vluchteling = persoonManager.getVluchteling(MyScanner.nextLine());

            if (vluchteling != null) {
                persoonManager.setActiefPersoon(vluchteling);
                break;
            }
            System.out.println("Deze vluchteling staat niet in het systeem.");
        }
    }

    public void toonMenu() {

        int keuze;
        boolean keuzeGemaakt = false;

        while (!keuzeGemaakt) {

            toonMenukeuze();

            System.out.print("\nKeuze: ");

            keuze = MyScanner.nextInt(0, menukeuzes.size() - 1);

            menukeuzes.get(keuze).execute();
            menuScherm.printTitel();
        }
    }

    public void voegKeuzeToe(Menukeuze menukeuze) {
        menukeuzes.add(menukeuze);
    }
}