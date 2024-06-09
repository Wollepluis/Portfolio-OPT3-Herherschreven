package menu;

import enums.PreMenuType;

public abstract class Menukeuze {

    private final String naam;

    public String getNaam() {
        return naam;
    }

    public Menukeuze(String naam) {
        this.naam = naam;
    }

    public void printTitel() {
        System.out.print("=== " + naam);
    }

    public void execute() {
        printTitel();
    }
}
