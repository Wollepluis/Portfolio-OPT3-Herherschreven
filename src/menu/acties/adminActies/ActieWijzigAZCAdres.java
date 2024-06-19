package menu.acties.adminActies;

import coaData.AZC;
import managers.VerblijfplaatsManager;
import menu.IActie;
import scanner.MyScanner;

public class ActieWijzigAZCAdres implements IActie {

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
