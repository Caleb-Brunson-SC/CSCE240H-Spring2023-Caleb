import java.util.*;

/**
 * Driver for the Prog3UI.java class.
 * @author Caleb Brunson.
 */

public class Driver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Prog-3UI!");
        System.out.println("Enter 'hiv' to learn about the disease:");

        String disease = keyboard.nextLine();
        if (disease.equalsIgnoreCase("hiv")) {
            Prog3UI progCLI = new Prog3UI();
            String regexFile = "project\\prog3-ui\\src\\regex-hiv.txt";
            String dataDir = "project\\prog3-ui\\data";
            progCLI.checkFile(regexFile);

            boolean quit = false;
            while(!quit) {
                System.out.println("What would you like to know about HIV?");
                String userInput = keyboard.nextLine().toLowerCase();
                System.out.println("---------------------------------");
                if (userInput.contains("everything")) {
                    progCLI.printEverything(dataDir);
                } else {
                    progCLI.findRegexMatch(regexFile, userInput);
                }
                System.out.println("---------------------------------");
                System.out.println("Enter 'quit' or 'q' to quit; enter 'c' to continue:");
                String userChoice = keyboard.nextLine();
                if (userChoice.equalsIgnoreCase("q") || userChoice.equalsIgnoreCase("quit")) {
                    quit = true;
                }
            }
        } else {
            System.out.println("Sorry, invalid input");
        }
    }
}
