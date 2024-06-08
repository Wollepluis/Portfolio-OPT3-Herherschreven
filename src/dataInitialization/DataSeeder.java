package dataInitialization;

import account.*;
import menu.*;
import menu.acties.ActieLogout;
import menu.acties.adminActies.*;
import enums.*;


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
        Account gebruikersAccount = new Account("Gebruiker");
        COAAccount coaAccount = new COAAccount("coa");
        AdminAccount adminAccount = new AdminAccount("Admin");

        voegGebruikerToe(gebruikersAccount);
        voegGebruikerToe(coaAccount);
        voegGebruikerToe(adminAccount);

        //Admin Menu initialization
        MenuScherm mainMenu1 = new MenuScherm("Main menu");
        MenuScherm subMenu1 = new MenuScherm("Beheer Land");
        MenuScherm subMenu2 = new MenuScherm("Gemeente Administratie");
        MenuScherm subMenu3 = new MenuScherm("Wijzig Land", PreMenuType.LAND);

        MenuActie voegLandToe = new ActieVoegLandToe("Voeg een land to aan de database");
        MenuActie voegGemeenteToe = new ActieVoegGemeenteToe("Voeg een gemeente toe aan de database");
        MenuActie logout = new ActieLogout("Logout");
        MenuActie verwijderLand = new ActieVerwijderLand("Verwijder dit land van de database");
        MenuActie wijzigVeiligheid = new ActieWijzigVeiligheid("Update veiligheidsstatus");
        MenuActie wijzigLandNaam = new ActieWijzigLandNaam("Wijzig naam");

        mainMenu1.menu.voegKeuzeToe(subMenu1);
        mainMenu1.menu.voegKeuzeToe(subMenu2);
        mainMenu1.menu.voegKeuzeToe(logout);

        subMenu1.menu.voegKeuzeToe(voegLandToe);
        subMenu1.menu.voegKeuzeToe(subMenu3);
        subMenu1.menu.voegKeuzeToe(mainMenu1);

        subMenu2.menu.voegKeuzeToe(voegGemeenteToe);
        subMenu2.menu.voegKeuzeToe(mainMenu1);

        subMenu3.menu.voegKeuzeToe(wijzigLandNaam);
        subMenu3.menu.voegKeuzeToe(wijzigVeiligheid);
        subMenu3.menu.voegKeuzeToe(verwijderLand);

        adminAccount.setMenu(mainMenu1);
    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }
}
