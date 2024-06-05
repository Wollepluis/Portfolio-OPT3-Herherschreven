package menu;

public abstract class Menukeuze {

    private final String naam;

    public String getNaam() {
        return naam;
    }

    public Menukeuze(String naam) {
        this.naam = naam;
    }

    public void printTitel() {
        System.out.println("=== " + naam);
    }

    public void execute() {
        printTitel();
    }
}
