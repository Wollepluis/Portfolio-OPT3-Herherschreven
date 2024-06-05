import account.Beveiliging;

public class Main {

    public static void main(String[] args) {
        Beveiliging beveiliging = Beveiliging.getInstance();

        while (true) {
            beveiliging.login();
        }
    }
}
