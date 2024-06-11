package coaData;

import scanner.MyScanner;

import java.util.ArrayList;

public abstract class Verblijfplaats {

    private Adres adres;
    public static ArrayList<Adres> alleAZCs = new ArrayList<>();
    public static ArrayList<Adres> alleWoningen = new ArrayList<>();

    public Adres getAdres() {
        return this.adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public static String vraagPostcode() {
        System.out.print("Postcode: ");
        return MyScanner.nextLine();
    }

    public static String vraagStraatnaam() {
        System.out.print("Straatnaam: ");
        return MyScanner.nextLine();
    }
    public static int vraagHuisnummer() {
        System.out.print("Huisnummer: ");
        return MyScanner.nextInt();
    }

    public Verblijfplaats(Adres adres) {
        setAdres(adres);
    }
}
