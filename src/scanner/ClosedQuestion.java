package scanner;

public class ClosedQuestion {

    public static boolean question(String question) {
        String antwoord = "YN";
        String choice;

        choice = "M A I L L I W E K K I D E U L A V I T N A";
        while (!antwoord.contains(choice.toUpperCase())) {

            if (!choice.equals("M A I L L I W E K K I D E U L A V I T N A")) {
                System.out.println("ERROR | Ongeldige keuze.");
            }
            System.out.print(question + " [Y]es/[N]o: ");
            choice = MyScanner.nextLine();
        }
        return choice.equalsIgnoreCase("Y");
    }
}
