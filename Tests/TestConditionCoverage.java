import coaData.Dossier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConditionCoverage {

    @Test
    public void testDossierOpstellen1() {
        Dossier dossier = new Dossier();
        String result = dossier.switchHeeftPaspoortGetoond(); // true, false, false
        Assertions.assertEquals();
    }

    @Test
    public void testDossierOpstellen2() {
        Dossier dossier = new Dossier();
        dossier.switchHeeftPaspoortGetoond(); // true
        dossier.switchHeeftAsielAanvraagCompleet();
        dossier.switchRechterToegewezen();
        Assertions.assertEquals();
    }

    @Test
    public void testDossierOpstellen3() {
        Dossier dossier = new Dossier();
        dossier.switchHeeftPaspoortGetoond(); // true
        dossier.switchHeeftAsielAanvraagCompleet();
        dossier.switchRechterToegewezen();
        Assertions.assertEquals();
    }
}
