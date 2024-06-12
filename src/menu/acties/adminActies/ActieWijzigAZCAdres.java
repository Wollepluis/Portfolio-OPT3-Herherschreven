package menu.acties.adminActies;

import coaData.AZC;
import coaData.Adres;
import coaData.Verblijfplaats;
import managers.VerblijfplaatsManager;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieWijzigAZCAdres extends MenuActie {
    public ActieWijzigAZCAdres(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
        AZC azc = verblijfplaatsManager.actiefAZC;

        System.out.println("Geef de nieuwe gegevens op.");
        System.out.print("Postcode: ");
        azc.getAdres().setPostcode(MyScanner.nextLine());
        System.out.print("Straatnaam: ");
        azc.getAdres().setStraatnaam(MyScanner.nextLine());
        System.out.print("Huisnummer: ");
        azc.getAdres().setHuisnummer(MyScanner.nextInt());
        System.out.println("Adres gewijzigd.");
    }
}
