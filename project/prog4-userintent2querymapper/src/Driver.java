package src;

import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        // Scanner
        Scanner keyboard = new Scanner(System.in);
        // Greet user
        System.out.println("Welcome to the Prog4 Chatbot!");
        System.out.println("Enter 'hiv' to learn about the disease:");
        // Get user input for disease type
        String disease = keyboard.nextLine();
        if (disease.equalsIgnoreCase("hiv")) {
            System.out.println("Enter what you would like to know about hiv:");
            // Loop boolean variable
            boolean quit = false;
            // Main loop
            while (!quit) {
                // Instance of ProgIntent class
                ProgIntent progIntent = ProgIntent.getInstance();
                // Get user utterance (u)
                String u = keyboard.nextLine();
                // Run query with u
                progIntent.matchUtterance(u);
                // Prompt user to quit
                System.out.println("Enter 'quit' or 'q' to quit; enter 'c' to continue:");
                String userChoice = keyboard.nextLine();
                if (userChoice.equalsIgnoreCase("q") || userChoice.equalsIgnoreCase("quit")) {
                    quit = true;
                }
            }
        }
    }
}
