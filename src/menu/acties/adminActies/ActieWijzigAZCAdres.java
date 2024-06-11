package menu.acties.adminActies;

import coaData.Adres;
import coaData.Verblijfplaats;
import menu.MenuActie;
import scanner.MyScanner;

public class ActieWijzigAZCAdres extends MenuActie {
    public ActieWijzigAZCAdres(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        Adres adres = Adres.actiefAdres;

        System.out.println("Geef de nieuwe gegevens op.");
        adres.setPostcode(MyScanner.nextLine());
        adres.setStraatnaam(MyScanner.nextLine());
        adres.setHuisnummer(MyScanner.nextInt());
        System.out.println("Adres gewijzigd.");
    }
}
