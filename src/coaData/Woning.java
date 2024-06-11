package coaData;

public class Woning extends Verblijfplaats {

    private Persoon eigenaar;

    public Persoon getEigenaar() {
        return this.eigenaar;
    }

    public void setEigenaar(Persoon eigenaar) {
        this.eigenaar = eigenaar;
    }

    public static Adres vraagNaarWoningAdres() {
        while (true) {
            System.out.println("Geef adres op.");
            Adres adres = getWoningAdres(vraagPostcode(), vraagStraatnaam(), vraagHuisnummer());

            if (adres != null) {
                return adres;
            }
            System.out.println("Dit adres staat niet in het systeem.");
        }
    }

    public static Adres getWoningAdres(String postcode, String straatnaam, int huisnummer) {

        for (Adres a : alleWoningen) {

            if (postcode.equalsIgnoreCase(a.getPostcode()) && straatnaam.equalsIgnoreCase(a.getStraatnaam()) && huisnummer == a.getHuisnummer()) {
                return a;
            }
        }
        return null;
    }
    public Woning(Adres adres, Persoon eigenaar) {
        super(adres);
        setEigenaar(eigenaar);
    }
}
