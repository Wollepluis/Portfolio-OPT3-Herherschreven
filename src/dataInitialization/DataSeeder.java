package dataInitialization;

import account.*;
import menu.*;
import menu.acties.adminActies.*;


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
        MenuScherm mainMenu1 = new MenuScherm("Admin");
        MenuScherm subMenu1 = new MenuScherm("Beheer Land");
        MenuScherm subMenu2 = new MenuScherm("Gemeente Administratie");

        mainMenu1.menu.voegKeuzeToe(subMenu1);
        mainMenu1.menu.voegKeuzeToe(subMenu2);
        subMenu1.menu.voegKeuzeToe(mainMenu1);

        MenuActie voegLandToe = new ActieVoegLandToe("Voeg een land to aan de database");
        MenuActie voegGemeenteToe = new ActieVoegGemeenteToe("Voeg een gemeente toe aan de database");

        subMenu1.menu.voegKeuzeToe(voegLandToe);
        subMenu2.menu.voegKeuzeToe(voegGemeenteToe);

        //gebruikersAccount.setMenu(mainMenu);
    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }
}
