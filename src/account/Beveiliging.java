package account;

import dataInitialization.DataSeeder;
import scanner.MyScanner;

public class Beveiliging {

    private static Beveiliging instance = null;
    private Account activeAccount;

    public static Beveiliging getInstance() {

        if (instance == null) {
            instance = new Beveiliging();
        }
        return instance;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    private void setActiveAccount(Account account) {
        this.activeAccount = account;
    }

    private Beveiliging() {
        setActiveAccount(null);
    }

    public boolean isLoggedIn() {
        return activeAccount != null;
    }

    public void login() {

        DataSeeder seeder = DataSeeder.getInstance();

        boolean loggedIn = false;

        System.out.println();
        System.out.println("=== Login");
        System.out.print("Gebruikersnaam: ");

        while (!loggedIn) {
            String gebruikersnaam = MyScanner.nextLine();
            Account account = seeder.getAccount(gebruikersnaam);

            if (account != null) {
                setActiveAccount(account);
                account.startMenu();
            }
            System.out.println("Onbekend Account.");
        }
    }

    public void logout() {
        setActiveAccount(null);
    }
}
