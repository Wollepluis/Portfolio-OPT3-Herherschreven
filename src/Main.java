import menu.MenuActie;
import menu.MenuScherm;
import menu.acties.Actie1;
import menu.acties.Actie2;

public class Main {

    public static void main(String[] args) {
        MenuScherm mainMenu = new MenuScherm("Main-menu");
        MenuScherm subMenu = new MenuScherm("Sub-menu");
        MenuActie print = new Actie1("Print een line");
        MenuActie print2 = new Actie2("Print een andere Line");

        mainMenu.menu.voegKeuzeToe(subMenu);
        subMenu.menu.voegKeuzeToe(mainMenu);
        subMenu.menu.voegKeuzeToe(print);
        subMenu.menu.voegKeuzeToe(print2);

        mainMenu.execute();
    }
}
