package coaData;

import java.util.ArrayList;

public class Adres {

    private Gemeente gemeente;
    private String postcode;
    private String straatnaam;
    private int huisnummer;

    private static final ArrayList<Adres> alleAdressen = new ArrayList<>();
    public static Adres actiefAdres;

    public Gemeente getGemeente() {
        return this.gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStraatnaam() {
        return this.straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return this.huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public static Adres getAdres(String postcode, String straatnaam, int huisnummer) {

        for (Adres a : alleAdressen) {

            if (postcode.equalsIgnoreCase(a.getPostcode()) && straatnaam.equalsIgnoreCase(a.getStraatnaam()) && huisnummer == a.getHuisnummer()) {
                return a;
            }
        }
        return null;
    }

    public static void setActiefAdres(Adres adres) {
        actiefAdres = adres;
    }
    public Adres(Gemeente gemeente, String postcode, String straatnaam, int huisnummer) {
        setGemeente(gemeente);
        setPostcode(postcode);
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
    }
}
