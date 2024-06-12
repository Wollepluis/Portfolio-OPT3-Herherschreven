package account;

import menu.MenuScherm;

public class Account {

    private String gebruikersnaam;
    private MenuScherm menu;

    public String getGebruikersnaam() {
        return this.gebruikersnaam;
    }

    public void setGebruikersnaam(String nieuwGebruikersnaam) {
        this.gebruikersnaam = nieuwGebruikersnaam;
    }

    public void setMenu(MenuScherm menu) {
        this.menu = menu;
    }

    public Account(String gebruikersnaam) {
        this.setGebruikersnaam(gebruikersnaam);
    }

    public boolean checkGebruikersnaam(String gebruikersnaam) {
        return this.getGebruikersnaam().equals(gebruikersnaam);
    }

    public void startMenu() {
        menu.execute();
    }
}
