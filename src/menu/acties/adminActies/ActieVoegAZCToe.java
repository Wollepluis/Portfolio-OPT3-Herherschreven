package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Gemeente;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieVoegAZCToe extends MenuActie {
    public ActieVoegAZCToe(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        System.out.println("In welke gemeente wil je een AZC toevoegen?");
        Gemeente gemeente = Gemeente.vraagNaarGemeente();

        while (true) {
            System.out.println("Welk adres heeft het nieuwe AZC?");
            String postcode = Adres.vraagPostcode();
            String straatnaam = Adres.vraagStraatnaam();
            int huisnummer = Adres.vraagHuisnummer();

            Adres adres = Adres.getAdres(postcode, straatnaam, huisnummer);

            if (adres == null) {
                System.out.print("Hoeveel plaatsen heeft dit AZC?: ");
                int aantalPlaatsen = MyScanner.nextInt(0);

                Adres nieuwAdres = new Adres(gemeente, postcode, straatnaam, huisnummer);
                AZC nieuwAZC = new AZC(nieuwAdres, aantalPlaatsen);

                gemeente.getLocaleAZCs().add(nieuwAZC);
                Adres.alleAdressen.add(nieuwAdres);

                System.out.println("AZC toegevoegd.");
            }
            System.out.println("Dit AZC Bestaat al.");
        }
    }
}
