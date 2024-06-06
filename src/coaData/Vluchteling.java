package coaData;

import java.util.ArrayList;

public class Vluchteling extends Persoon {

    private Land landVanHerkomst;
    private Dossier dossier;
    private static final ArrayList<Vluchteling> alleVluchtelingen = new ArrayList<>();

    public Land getLandVanHerkomst() {
        return this.landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public Dossier getDossier() {
        return this.dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public ArrayList<Vluchteling> getAlleVluchtelingen() {
        return alleVluchtelingen;
    }

    public void addVluchteling(Vluchteling vluchteling) {
        alleVluchtelingen.add(vluchteling);
    }

    public Vluchteling(String naam, Land landVanHerkomst) {
        super(naam);
        setDossier(new Dossier());
        setLandVanHerkomst(landVanHerkomst);
    }

    @Override
    public void registreerWoning(Verblijfplaats verblijfplaats) {
        super.setVerblijfplaats(verblijfplaats);
    }
}
