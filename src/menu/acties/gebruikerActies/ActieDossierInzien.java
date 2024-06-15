package menu.acties.gebruikerActies;

import account.Beveiliging;
import coaData.Vluchteling;
import managers.PersoonManager;
import menu.MenuActie;

public class ActieDossierInzien extends MenuActie {
    public ActieDossierInzien(String naam) {
        super(naam);
    }

    @Override
    public void execute() {
        PersoonManager persoonManager = PersoonManager.getInstance();
        persoonManager.actiefPersoon = Beveiliging.getInstance().getActiveAccount().getPersoon();

        Vluchteling vluchteling = (Vluchteling) persoonManager.actiefPersoon;
        vluchteling.getDossier().stelDossierOp();
    }
}
