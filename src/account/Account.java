package account;

import coaData.Persoon;
import menu.Menu;

public class Account {

    private String gebruikersnaam;
    private Menu menu;
    Persoon persoon;

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }

    public void setGebruikersnaam(String nieuwGebruikersnaam) {
        this.gebruikersnaam = nieuwGebruikersnaam;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Account(String gebruikersnaam) {
        this.setGebruikersnaam(gebruikersnaam);
    }

    public boolean checkGebruikersnaam(String gebruikersnaam) {
        return this.getGebruikersnaam().equals(gebruikersnaam);
    }

    public void startMenu() {
        menu.toonMenu();
    }
}
