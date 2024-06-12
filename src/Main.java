import account.Beveiliging;
import coaData.*;

public class Main {

    public static void main(String[] args) {
        Beveiliging beveiliging = Beveiliging.getInstance();

//        Gemeente gemeente = new Gemeente("gemeente", 3);
//        Adres adres = new Adres(gemeente,"q", "q",3);
//        AZC azc = new AZC(adres, 3);
//        Land nederland = new Land("Nederland", true);
//        Vluchteling vluchteling = new Vluchteling("Abishek", nederland);
//
//        gemeente.voegAZCToe(azc);
//        azc.voegVluchtelingToe(vluchteling);


        while (true) {
            beveiliging.login();
        }
    }
}
