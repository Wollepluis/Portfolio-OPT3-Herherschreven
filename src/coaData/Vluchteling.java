package coaData;

import scanner.MyScanner;

import java.util.ArrayList;

public class Vluchteling extends Persoon {

    private Land landVanHerkomst;
    private Dossier dossier;
    public static final ArrayList<Vluchteling> alleVluchtelingen = new ArrayList<>();
    public static Vluchteling actiefVluchteling;

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

    public static void setActiefVluchteling(Vluchteling vluchteling) {
        actiefVluchteling = vluchteling;
    }

    public static Vluchteling vraagNaarVluchteling() {
        while (true) {
            System.out.print("Naam: ");
            Vluchteling vluchteling = getVluchteling(MyScanner.nextLine());

            if (vluchteling != null) {
                return vluchteling;
            }
            System.out.println("Deze vluchteling staat niet in het systeem.");
        }
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
