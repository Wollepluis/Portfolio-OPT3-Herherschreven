package coaData;

public class Woning extends Verblijfplaats {

    private Persoon eigenaar;

    public Persoon getEigenaar() {
        return this.eigenaar;
    }

    public void setEigenaar(Persoon eigenaar) {
        this.eigenaar = eigenaar;
    }

    public Woning(Adres adres, Persoon eigenaar) {
        super(adres);
        setEigenaar(eigenaar);
    }

    @Override
    public void vertrekVerblijfplaats() {

    }

    @Override
    public void registreerWoning() {

    }

    @Override
    public void zetInNieuwVerblijfplaats() {

    }
}
