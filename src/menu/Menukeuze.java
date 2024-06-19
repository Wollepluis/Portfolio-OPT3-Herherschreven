package menu;

public class Menukeuze {

    private String titel;
    private IActie actie;

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public IActie getActie() {
        return this.actie;
    }

    public void setActie(IActie actie) {
        this.actie = actie;
    }

    public Menukeuze(String titel, IActie actie) {
        this.setTitel(titel);
        this.setActie(actie);
    }
}

