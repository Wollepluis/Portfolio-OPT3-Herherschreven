package coaData;

import enums.EigenWoning;
import enums.RechterUitspraak;

public class Dossier {

    private boolean heeftPaspoortGetoond;
    private boolean heeftAsielAanvraagCompleet;
    private boolean rechterToegewezen;
    private RechterUitspraak rechterUitspraak;
    private EigenWoning heeftEigenWoning;

    public boolean getHeeftPaspoortGetoond() {
        return this.heeftPaspoortGetoond;
    }

    public void switchHeeftPaspoortGetoond() {
        this.heeftPaspoortGetoond = !heeftPaspoortGetoond;
    }

    public boolean getHeeftAsielAanvraagCompleet() {
        return this.heeftAsielAanvraagCompleet;
    }

    public void switchHeeftAsielAanvraagCompleet() {
        this.heeftAsielAanvraagCompleet = !heeftAsielAanvraagCompleet;
    }

    public boolean getRechterToegewezen() {
        return rechterToegewezen;
    }

    public void switchRechterToegewezen() {
        this.rechterToegewezen = !rechterToegewezen;
    }

    public RechterUitspraak getRechterUitspraak() {
        return rechterUitspraak;
//        return switch (this.rechterUitspraak) {
//            case RechterUitspraak.GEACCEPTEERD -> "Geaccepteerd";
//            case RechterUitspraak.AFGEWEZEN -> "Afgewezen";
//            case RechterUitspraak.GEEN_BESLUIT -> "Geen besluit";
//        };
    }

    public void setRechterUitspraak(RechterUitspraak rechterUitspraak) {
        this.rechterUitspraak = rechterUitspraak;
    }

    public EigenWoning getHeeftEigenWoning() {
        return this.heeftEigenWoning;
    }

    public void setHeeftEigenWoning(EigenWoning eigenWoning) {
        this.heeftEigenWoning = eigenWoning;
    }

    public Dossier() {
        this.heeftPaspoortGetoond = false;
        this.heeftAsielAanvraagCompleet = false;
        this.rechterToegewezen = false;
        setRechterUitspraak(RechterUitspraak.GEEN_BESLUIT);
        setHeeftEigenWoning(EigenWoning.NEE);
    }

    public void stelDossierOp() {

    }
}
