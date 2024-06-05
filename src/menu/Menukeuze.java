package menu;

public abstract class Menukeuze {

    public String naam;

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
