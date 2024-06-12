package coaData;

public class Land {

    private String naam;
    private boolean isVeilig;

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isVeilig() {
        return this.isVeilig;
    }

    public void setVeilig(boolean isVeilig) {
        this.isVeilig = isVeilig;
    }

    public void switchIsVeilig() {
        this.isVeilig = !isVeilig;
    }

    public Land(String naam, boolean isVeilig) {
        setNaam(naam);
        setVeilig(isVeilig);
    }
}
