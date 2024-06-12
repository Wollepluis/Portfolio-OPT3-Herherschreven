import account.Beveiliging;

public class Main {
    /**
     * Programma begint met het aanroepen van de class 'Beveiliging' waar direct een instance van wordt aangemaakt vanwege
     * het Singleton pattern.
     *
     * Gaat daarna direct in een 'while-loop' (die in feite nooit stopt) waarin de methode 'login()' wordt aangeroepen.
     */
    public static void main(String[] args) {
        Beveiliging beveiliging = Beveiliging.getInstance();

        while (true) {
            beveiliging.login();
        }
    }
}
