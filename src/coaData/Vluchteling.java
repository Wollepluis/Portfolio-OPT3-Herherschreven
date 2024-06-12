package coaData;

import scanner.MyScanner;

import java.util.ArrayList;

public class Vluchteling extends Persoon {

    private Land landVanHerkomst;
    private Dossier dossier;


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
