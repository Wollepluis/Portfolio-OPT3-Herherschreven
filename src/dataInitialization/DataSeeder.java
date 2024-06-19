package dataInitialization;

import account.Account;
import account.AdminAccount;
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

    public Account getAccount(String gebruikersnaam) {

        for (Account a : accounts) {

            if (a.checkGebruikersnaam(gebruikersnaam)) {
                return a;
            }
        }
        return null;
    }

    private void voegGebruikerToe(Account account) {
        accounts.add(account);
    }

    private void initialize() {
        //Manager initialization
        GemeenteManager gemeenteManager = GemeenteManager.getInstance();
        LandManager landManager = LandManager.getInstance();
        VerblijfplaatsManager verblijfplaatsManager = VerblijfplaatsManager.getInstance();
        PersoonManager persoonManager = PersoonManager.getInstance();

        //Gebruiker initialization
        COAAccount coaAccount = new COAAccount("coa");
        AdminAccount adminAccount = new AdminAccount("Admin");
        voegGebruikerToe(coaAccount);
        voegGebruikerToe(adminAccount);

        //Land initialization
        Land ghana = new Land("Ghana", false);
        Land afghanistan = new Land("Afghanistan", true);
        landManager.alleLanden.add(ghana);
        landManager.alleLanden.add(afghanistan);

        // Persoon initialization
        Vluchteling joe = new Vluchteling("Joe", ghana);
        Account gebruikersaccount1 = new Account("joe");
        voegGebruikerToe(gebruikersaccount1);
        joe.setAccount(gebruikersaccount1);
        gebruikersaccount1.setPersoon(joe);

        Vluchteling jane = new Vluchteling("Jane", afghanistan);
        Account gebruikersAccount2 = new Account("jane");
        voegGebruikerToe(gebruikersAccount2);
        jane.setAccount(gebruikersAccount2);
        gebruikersAccount2.setPersoon(jane);

        //Gemeente initialization
        Gemeente denHaag = new Gemeente("Den Haag", 562000);
        Gemeente amsterdam = new Gemeente("Amsterdam", 918000);
        Gemeente rotterdam = new Gemeente("Rotterdam", 663000);
        gemeenteManager.alleGemeentes.add(denHaag);
        gemeenteManager.alleGemeentes.add(amsterdam);
        gemeenteManager.alleGemeentes.add(rotterdam);

        //Adres initialization
        Adres adres1 = new Adres(amsterdam, "1067SL", "Willinklaan", 3);
        Adres adres2 = new Adres(denHaag, "2517AS", "Laan van Meerdervoort",108);
        Adres adres3 = new Adres(denHaag, "2492RC", "Libelsingel", 72);

        //AZC initialization
        AZC azc1 = new AZC(adres1, 700);
        AZC azc2 = new AZC(adres2, 600);
        amsterdam.getLocaleAZCs().add(azc1);
        denHaag.getLocaleAZCs().add(azc2);
        verblijfplaatsManager.alleAZCs.add(azc1);
        verblijfplaatsManager.alleAZCs.add(azc2);

        azc1.voegVluchtelingToe(joe);
        persoonManager.alleVluchtelingen.add(joe);
        joe.setVerblijfplaats(azc1);

        azc2.voegVluchtelingToe(jane);
        persoonManager.alleVluchtelingen.add(jane);
        jane.setVerblijfplaats(azc2);

        //Woning initialization
        Woning woning1 = new Woning(adres3, joe);
        verblijfplaatsManager.alleWoningen.add(woning1);


    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }
}
