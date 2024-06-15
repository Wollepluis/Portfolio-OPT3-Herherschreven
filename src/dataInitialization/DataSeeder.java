package dataInitialization;

import account.Account;
import account.AdminAccount;
import account.COAAccount;
import coaData.*;
import enums.PreMenuType;
import managers.GemeenteManager;
import managers.LandManager;
import managers.PersoonManager;
import managers.VerblijfplaatsManager;
import menu.MenuActie;
import menu.MenuScherm;
import menu.acties.ActieLogout;
import menu.acties.adminActies.*;
import menu.acties.coaActies.ActieOverplaatsen;
import menu.acties.gebruikerActies.*;

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

        //Admin Menu initialization
        MenuScherm mainMenu1 = new MenuScherm("Main menu");
        MenuScherm subMenu1 = new MenuScherm("Beheer Land");
        MenuScherm subMenu2 = new MenuScherm("Gemeente Administratie");
        MenuScherm subMenu3 = new MenuScherm("Wijzig Land", PreMenuType.LAND);
        MenuScherm subMenu4 = new MenuScherm("Beheer Gemeente", PreMenuType.GEMEENTE);
        MenuScherm subMenu5 = new MenuScherm("Beheer AZCs", PreMenuType.AZC);

        MenuActie voegLandToe = new ActieVoegLandToe("Voeg een land toe aan de database");
        MenuActie voegGemeenteToe = new ActieVoegGemeenteToe("Voeg een gemeente toe aan de database");
        MenuActie logout = new ActieLogout("Logout");
        MenuActie verwijderLand = new ActieVerwijderLand("Verwijder dit land van de database");
        MenuActie wijzigVeiligheid = new ActieWijzigVeiligheid("Update veiligheidsstatus");
        MenuActie wijzigLandNaam = new ActieWijzigLandNaam("Wijzig naam");
        MenuActie voegAZCToe = new ActieVoegAZCToe("Voeg nieuw AZC Toe");
        MenuActie wijzigGemeenteNaam = new ActieWijzigGemeenteNaam("Wijzig naam van Gemeente");
        MenuActie wijzigAantalInwoners = new ActieWijzigAantalInwoners("Wijzig aantal inwoners");
        MenuActie rapportageOpvragen = new ActieRapportageOpvragen("Rapportage opvragen");
        MenuActie wijzigAZCAdres = new ActieWijzigAZCAdres("Wijzig Adres");
        MenuActie verwijderAZCAdres = new ActieVerwijderAZC("Verwijder AZC");

        mainMenu1.menu.voegKeuzeToe(subMenu1);
        mainMenu1.menu.voegKeuzeToe(subMenu2);
        mainMenu1.menu.voegKeuzeToe(logout);

        subMenu1.menu.voegKeuzeToe(voegLandToe);
        subMenu1.menu.voegKeuzeToe(subMenu3);
        subMenu1.menu.voegKeuzeToe(mainMenu1);

        subMenu2.menu.voegKeuzeToe(voegGemeenteToe);
        subMenu2.menu.voegKeuzeToe(subMenu4);
        subMenu2.menu.voegKeuzeToe(mainMenu1);

        subMenu3.menu.voegKeuzeToe(wijzigLandNaam);
        subMenu3.menu.voegKeuzeToe(wijzigVeiligheid);
        subMenu3.menu.voegKeuzeToe(verwijderLand);
        subMenu3.menu.voegKeuzeToe(subMenu1);

        subMenu4.menu.voegKeuzeToe(wijzigGemeenteNaam);
        subMenu4.menu.voegKeuzeToe(wijzigAantalInwoners);
        subMenu4.menu.voegKeuzeToe(voegAZCToe);
        subMenu4.menu.voegKeuzeToe(subMenu5);
        subMenu4.menu.voegKeuzeToe(rapportageOpvragen);
        subMenu4.menu.voegKeuzeToe(subMenu2);

        subMenu5.menu.voegKeuzeToe(wijzigAZCAdres);
        subMenu5.menu.voegKeuzeToe(verwijderAZCAdres);
        subMenu5.menu.voegKeuzeToe(subMenu4);

        adminAccount.setMenu(mainMenu1);

        //COA Menu Initialization
        MenuScherm mainMenu2 = new MenuScherm("Main Menu");
        MenuScherm subMenu6 = new MenuScherm("Beheer Vluchteling", PreMenuType.NAAM);

        MenuActie overplaatsen = new ActieOverplaatsen("Overplaatsen naar een ander verblijf");

        mainMenu2.menu.voegKeuzeToe(subMenu6);
        mainMenu2.menu.voegKeuzeToe(logout);

        subMenu6.menu.voegKeuzeToe(mainMenu2);
        subMenu6.menu.voegKeuzeToe(overplaatsen);

        coaAccount.setMenu(mainMenu2);


        //Gebruiker MenuInitialization
        MenuScherm mainMenu3 = new MenuScherm("Main Menu");

        MenuActie profiel = new ActieProfiel("Profiel");
        MenuActie dossierInzien = new ActieDossierInzien("Dossier bekijken");
        MenuActie adresRegistreren = new ActieAdresRegistreren("Adres Registreren");

        mainMenu3.menu.voegKeuzeToe(profiel);
        mainMenu3.menu.voegKeuzeToe(dossierInzien);
        mainMenu3.menu.voegKeuzeToe(adresRegistreren);
        mainMenu3.menu.voegKeuzeToe(logout);

        gebruikersaccount1.setMenu(mainMenu3);
        gebruikersAccount2.setMenu(mainMenu3);
    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }
}
