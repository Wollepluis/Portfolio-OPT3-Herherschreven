package account;

import dataInitialization.DataSeeder;
import scanner.MyScanner;

public class Beveiliging {
    /**
     * In de variabele 'activeAccount' wordt het account waarmee wordt ingelogd tijdelijk opgeslagen. Hierdoor kan
     * gecheckt worden of deze 'null' is (niemand is ingelogd) of later opgehaald worden.
     */
    private static Beveiliging instance = null;
    private Account activeAccount; //Hierin wordt het account dat gebruikt wordt na inloggen tijdelijk opgeslagen.

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

    /**
     * Constructor. Wanneer het programma start zal het actieve account altijd beginnen op 'null'.
     */
    private Beveiliging() {
        this.setActiveAccount(null);
    }

    public boolean isLoggedIn() {
        return activeAccount != null;
    }

    /**
     * Er wordt een instance van DataSeeder aangemaakt. Hiermee wordt ook direct alle data geïnitialiseerd, waaronder
     * de accounts die al van tevoren zijn aangemaakt.
     *
     * Wanneer de juiste gebruikersnaam is ingevoerd wordt de variabele 'activeAccount' geïnitialiseerd en wordt het
     * eerste menu gestart.
     * Deze gaat door wegens de 'while-loop' totdat er weer wordt uitgelogd met de methode 'logout()'.
     */
    public void login() {
        DataSeeder seeder = DataSeeder.getInstance();

        boolean loggedIn = false;

        System.out.println("\n=== Login");
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
