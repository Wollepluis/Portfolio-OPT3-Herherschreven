package coaData;

import account.Account;

public class Persoon {

    private String naam;
    private Verblijfplaats verblijfplaats;
    private Account account;

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Verblijfplaats getVerblijfplaats() {
        return this.verblijfplaats;
    }

    public void setVerblijfplaats(Verblijfplaats verblijfplaats) {
        this.verblijfplaats = verblijfplaats;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Persoon(String naam, Verblijfplaats verblijfplaats) {
        setNaam(naam);
        setVerblijfplaats(verblijfplaats);
    }

    public Persoon(String naam) {
        setNaam(naam);
    }

    public void registreerWoning(Verblijfplaats verblijfplaats) {
        System.out.println("ERROR: U bent niet bevoegd een woning te registreren.");
    }
}
