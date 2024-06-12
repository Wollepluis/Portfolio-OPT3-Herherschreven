package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Gemeente;
import managers.GemeenteManager;
import coaData.Verblijfplaats;
import managers.VerblijfplaatsManager;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieVoegAZCToe extends MenuActie {
    public ActieVoegAZCToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        Gemeente gemeente = gemeenteManager.actiefGemeente;

        while (true) {
            System.out.println("Welk adres heeft het nieuwe AZC?");
            System.out.print("Postcode: ");
            String postcode = MyScanner.nextLine();
            System.out.print("Straatnaam: ");
            String straatnaam = MyScanner.nextLine();
            System.out.print("Huisnummer: ");
            int huisnummer = MyScanner.nextInt(0);

            Adres adres = gemeente.getLokaalAZC(postcode, straatnaam, huisnummer).getAdres();

            if (adres == null) {
                System.out.print("Hoeveel plaatsen heeft dit AZC?: ");
                int aantalPlaatsen = MyScanner.nextInt(0);

                Adres nieuwAdres = new Adres(gemeente, postcode, straatnaam, huisnummer);
                AZC nieuwAZC = new AZC(nieuwAdres, aantalPlaatsen);

                VerblijfplaatsManager.getInstance().alleVerblijfplaatsen.add(nieuwAZC);
                gemeente.getLocaleAZCs().add(nieuwAZC);

                System.out.println("AZC toegevoegd.");
                break;
            }
            System.out.println("Dit AZC Bestaat al.");
        }
    }
}
