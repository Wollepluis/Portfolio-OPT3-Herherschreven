package dataInitialization;

import account.Account;
import account.AdminAccount;
import account.COAAccount;
import menu.MenuActie;
import menu.MenuScherm;
import menu.acties.Actie1;
import menu.acties.Actie2;

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

        MenuScherm mainMenu = new MenuScherm("Main-menu");
        MenuScherm subMenu = new MenuScherm("Sub-menu");
        MenuActie print = new Actie1("Print een line");
        MenuActie print2 = new Actie2("Print een andere Line");


        mainMenu.menu.voegKeuzeToe(subMenu);
        subMenu.menu.voegKeuzeToe(mainMenu);
        subMenu.menu.voegKeuzeToe(print);
        subMenu.menu.voegKeuzeToe(print2);

        gebruikersAccount.setMenu(mainMenu);
    }

    private DataSeeder() {
        accounts = new ArrayList<>();
        initialize();
    }
}
