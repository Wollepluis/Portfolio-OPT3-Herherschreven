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

    public void setNieuwVerblijfplaats(Verblijfplaats verblijfplaats) {
        persoonManager.actiefPersoon.setVerblijfplaats(verblijfplaats);
    }
    public void verhuis(Persoon persoon, Verblijfplaats nieuwVerblijfplaats) {
        vertrekVerblijfplaats(persoon);
        setNieuwVerblijfplaats(nieuwVerblijfplaats);
        zetInNieuwVerblijfplaats(persoon, nieuwVerblijfplaats);
    }

    public abstract void vertrekVerblijfplaats(Persoon persoon);
    public abstract void zetInNieuwVerblijfplaats(Persoon persoon, Verblijfplaats verblijfplaats);

}
