package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Gemeente;
import coaData.Verblijfplaats;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieVoegAZCToe extends MenuActie {
    public ActieVoegAZCToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Gemeente gemeente = Gemeente.actiefGemeente;

        while (true) {
            System.out.println("Welk adres heeft het nieuwe AZC?");
            String postcode = Verblijfplaats.vraagPostcode();
            String straatnaam = Verblijfplaats.vraagStraatnaam();
            int huisnummer = Verblijfplaats.vraagHuisnummer();

            Adres adres = AZC.getAZCAdres(postcode, straatnaam, huisnummer);

            if (adres == null) {
                System.out.print("Hoeveel plaatsen heeft dit AZC?: ");
                int aantalPlaatsen = MyScanner.nextInt(0);

                Adres nieuwAdres = new Adres(gemeente, postcode, straatnaam, huisnummer);
                AZC nieuwAZC = new AZC(nieuwAdres, aantalPlaatsen);

                gemeente.getLocaleAZCs().add(nieuwAZC);
                AZC.alleAZCs.add(nieuwAdres);

                System.out.println("AZC toegevoegd.");
                break;
            }
            System.out.println("Dit AZC Bestaat al.");
        }
    }
}
