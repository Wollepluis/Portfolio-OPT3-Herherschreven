package coaData;

public class Woning extends Verblijfplaats {

    private Persoon eigenaar;

    public Persoon getEigenaar() {
        return this.eigenaar;
    }

    public void setEigenaar(Persoon eigenaar) {
        this.eigenaar = eigenaar;
    }

    public Woning(Adres adres) {
        super(adres);
    }

    @Override
    public void vertrekVerblijfplaats() {

    }

    @Override
    public void registreerWoning() {

    }

    @Override
    public void zetInNieuwVerblijfplaats(Persoon persoon) {
        setEigenaar(persoon);
        persoon.setVerblijfplaats(this);
    }
}
