package coaData;

import managers.PersoonManager;

public abstract class Verblijfplaats {

    private Adres adres;
    PersoonManager persoonManager = PersoonManager.getInstance();


    public Adres getAdres() {
        return this.adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Verblijfplaats(Adres adres) {
        setAdres(adres);
    }

    public void verhuis() {
        vertrekVerblijfplaats();
        registreerWoning();
        zetInNieuwVerblijfplaats();
    }

    public abstract void vertrekVerblijfplaats();

    public abstract void registreerWoning();
    public abstract void zetInNieuwVerblijfplaats();

}
