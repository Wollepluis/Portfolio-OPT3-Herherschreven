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

    public void verhuis(Persoon persoon) {
        vertrekVerblijfplaats();
        registreerWoning();
        zetInNieuwVerblijfplaats(persoon);
    }
    public abstract void vertrekVerblijfplaats();

    public abstract void registreerWoning();
    public abstract void zetInNieuwVerblijfplaats(Persoon persoon);

}
