package scanner;

import java.util.Scanner;

public class MyScanner {

    public static String nextLine() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            if (sc.hasNextLine()) {
                return sc.nextLine();
            }
            else {
                System.out.print("Voer een geldige tekst in: ");
                sc.next();
            }
        }
    }

    public static int nextInt() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            else {
                System.out.print("Voer een getal in: ");
                sc.next();
            }
        }
    }

    public static int nextInt(int minValue, int maxValue) {

        int x = Integer.MIN_VALUE;
        while (x < minValue || x > maxValue) {
            x = nextInt();
        }
        return x;
    }

    public static int nextInt(int mustBeHigherThan) {

        int x = mustBeHigherThan;
        while (x <= mustBeHigherThan) {
            x = nextInt();
        }
        return x;
    }
}
