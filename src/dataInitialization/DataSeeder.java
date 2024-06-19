package dataInitialization;

import account.Account;
import account.COAAccount;
import coaData.*;
import managers.GemeenteManager;
import managers.LandManager;
import managers.PersoonManager;
import managers.VerblijfplaatsManager;

import java.util.ArrayList;

public class DataSeeder {

    private static DataSeeder instance = null;
    private final ArrayList<Account> accounts;

    public static DataSeeder getInstance() {

        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }

    public Account getAccount(String gebruikersnaam) {

        for (Account a : accounts) {

            if (a.checkGebruikersnaam(gebruikersnaam)) {
                return a;
            }
        }
        return null;
    }

    private void voegGebruikerToe(Account account, Persoon persoon) {
        persoon.setAccount(account);
        account.setPersoon(persoon);
        accounts.add(account);
    }

    private void initialize() {
        //Manager initialization
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        LandManager landManager = LandManager.getInstance();
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
        PersoonManager persoonManager = PersoonManager.getInstance();

        //Land initialization
        Land ghana = new Land("Ghana", false);
        Land afghanistan = new Land("Afghanistan", true);
        landManager.alleLanden.add(ghana);
        landManager.alleLanden.add(afghanistan);

        //Gemeente initialization
        Gemeente denHaag = new Gemeente("Den Haag", 562000);
        Gemeente amsterdam = new Gemeente("Amsterdam", 918000);
        Gemeente rotterdam = new Gemeente("Rotterdam", 663000);
        Gemeente westland = new Gemeente("Westland", 108603);
        gemeenteManager.alleGemeentes.add(denHaag);
        gemeenteManager.alleGemeentes.add(amsterdam);
        gemeenteManager.alleGemeentes.add(rotterdam);
        gemeenteManager.alleGemeentes.add(westland);

        //Adres initialization
        Adres adres1 = new Adres(amsterdam, "1067SL", "Willinklaan", 3);
        Adres adres2 = new Adres(denHaag, "2517AS", "Laan van Meerdervoort",108);
        Adres adres3 = new Adres(denHaag, "2492RC", "Libelsingel", 72);
        Adres adres4 = new Adres(denHaag, "2675EK", "Prinsenland", 16);

        //AZC initialization
        Verblijfplaats azc1 = new AZC(adres1, 700);
        Verblijfplaats azc2 = new AZC(adres2, 600);
        verblijfplaatsManager.voegVerblijfplaatsToe(azc1);
        verblijfplaatsManager.voegVerblijfplaatsToe(azc2);

        //Woning initialization
        Verblijfplaats woning1 = new Woning(adres3);
        Verblijfplaats woning2 = new Woning(adres4);
        verblijfplaatsManager.voegVerblijfplaatsToe(woning1);
        verblijfplaatsManager.voegVerblijfplaatsToe(woning2);

        // Persoon initialization
        Persoon joe = new Vluchteling("Joe", ghana);
        persoonManager.allePersonen.add(joe);
        azc1.zetInNieuwVerblijfplaats(joe);
        Account gebruikersaccount1 = new Account("joe");
        voegGebruikerToe(gebruikersaccount1, joe);

        Persoon jane = new Vluchteling("Jane", afghanistan);
        persoonManager.allePersonen.add(joe);
        azc1.zetInNieuwVerblijfplaats(jane);
        Account gebruikersAccount2 = new Account("jane");
        voegGebruikerToe(gebruikersAccount2, jane);

        Persoon marianne = new COAMedewerker("Marianne", false);
        persoonManager.allePersonen.add(marianne);
        woning1.zetInNieuwVerblijfplaats(marianne);
        Account coaAccount = new COAAccount("coa");
        voegGebruikerToe(coaAccount, marianne);

        Persoon xander = new COAMedewerker("Xander", true);
        persoonManager.allePersonen.add(xander);
        woning2.zetInNieuwVerblijfplaats(xander);
        Account adminAccount = new Account("admin");
        voegGebruikerToe(adminAccount, xander);

        //adminmenu
    }
}
