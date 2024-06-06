package coaData;

import java.util.ArrayList;

public class Vluchteling extends Persoon {

    private Land landVanHerkomst;
    private static final ArrayList<Vluchteling> alleVluchtelingen = new ArrayList<>();

    public Land getLandVanHerkomst() {
        return this.landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public ArrayList<Vluchteling> getAlleVluchtelingen() {
        return alleVluchtelingen;
    }

    public void addVluchteling(Vluchteling vluchteling) {
        alleVluchtelingen.add(vluchteling);
    }

    public Vluchteling(String naam, Land landVanHerkomst) {
        super(naam);
        setLandVanHerkomst(landVanHerkomst);
    }

    @Override
    public void registreerWoning(Verblijfplaats verblijfplaats) {
        super.setVerblijfplaats(verblijfplaats);
    }
}
