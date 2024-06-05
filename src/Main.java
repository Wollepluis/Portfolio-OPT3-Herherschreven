import account.Beveiliging;
import dataInitialization.DataSeeder;
import menu.MenuActie;
import menu.MenuScherm;
import menu.acties.Actie1;
import menu.acties.Actie2;

public class Main {

    public static void main(String[] args) {
        Beveiliging beveiliging = Beveiliging.getInstance();

        while (true) {
            beveiliging.login();
        }
    }
}
