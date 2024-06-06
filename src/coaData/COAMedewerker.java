package coaData;

public class COAMedewerker extends Persoon {

    private boolean isAdmin;

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void switchAdmin() {
        this.isAdmin = !isAdmin;
    }

    public COAMedewerker(String naam, boolean isAdmin) {
        super(naam);
        setAdmin(isAdmin);
    }
}
