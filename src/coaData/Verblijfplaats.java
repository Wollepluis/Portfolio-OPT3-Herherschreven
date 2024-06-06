package coaData;

public abstract class Verblijfplaats {

    private Adres adres;

    public Adres getAdres() {
        return this.adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Verblijfplaats(Adres adres) {
        setAdres(adres);
    }
}
