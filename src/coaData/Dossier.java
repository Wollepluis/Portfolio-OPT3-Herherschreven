package coaData;

import enums.EigenWoning;
import enums.RechterUitspraak;
import managers.PersoonManager;

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

    public String getRechterUitspraak() {
        return switch (this.rechterUitspraak) {
            case RechterUitspraak.GEACCEPTEERD -> "Geaccepteerd";
            case RechterUitspraak.AFGEWEZEN -> "Afgewezen";
            case RechterUitspraak.GEEN_BESLUIT -> "Geen besluit";
        };
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
        PersoonManager persoonManager = PersoonManager.getInstance();

        Vluchteling vluchteling = (Vluchteling) persoonManager.actiefPersoon;

        System.out.printf("=== %s ===\n", vluchteling.getNaam());
        System.out.println("Land van Herkomst: " + vluchteling.getLandVanHerkomst() + "\n");
        System.out.println("Heeft paspoort getoond: " + jaNee(heeftPaspoortGetoond));
        System.out.println("Heeft Asielaanvraag compleet: " + jaNee(heeftAsielAanvraagCompleet));
        System.out.println("Rechter toegewezen: " + jaNee(rechterToegewezen));

        if (rechterToegewezen) {
            System.out.println("\nNaam Rechter: ");
        }

        if (getRechterUitspraak().equals("Geen besluit")) {
            System.out.println("\nWachten op rechter uitspraak");
        }

        if (heeftPaspoortGetoond && heeftAsielAanvraagCompleet && rechterToegewezen) {

            if (getRechterUitspraak().equals("Geaccepteerd")) {
                System.out.println("\n" + vluchteling.getNaam() + " is toegelaten tot de nederlandse samenleving.");
            }
            else {
                System.out.println("\n" + vluchteling.getNaam() + " is niet toegelaten tot de nederlandse samenleving.");
            }
        }
        System.out.println("\n==========\n");
    }

    public String jaNee (boolean x) {
        if (x) {
            return "ja";
        }
        else {
            return "nee";
        }
    }
}
