package coaData;

import java.util.ArrayList;

public class Vluchteling extends Persoon {

    private Land landVanHerkomst;
    private Dossier dossier;
    private static final ArrayList<Vluchteling> alleVluchtelingen = new ArrayList<>();
    private static Vluchteling actiefVluchteling;

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

    public static Vluchteling getVluchteling(String vluchtelingNaam) {

        for (Vluchteling v : alleVluchtelingen) {

            if (vluchtelingNaam.equalsIgnoreCase(v.getNaam())) {
                return v;
            }
        }
        return null;
    }

    public static void setActiefVluchteling(String vluchtelingNaam) {
        actiefVluchteling = getVluchteling(vluchtelingNaam);
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
