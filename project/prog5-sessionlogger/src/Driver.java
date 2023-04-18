package src;
import java.util.Scanner;
import java.util.HashMap;

public class Driver {
    public static void main(String[] args) {
        // utterance
        HashMap<String, String> sessionMap = new HashMap<String, String>();
        // Time tracking
        long start = System.nanoTime();
        // Scanner
        Scanner keyboard = new Scanner(System.in);
        // Greet user
        System.out.println("Welcome to the Prog5-SessionLogger Chatbot!");
        System.out.println("Enter 'hiv' to learn about the disease:");
        // Get user input for disease type
        String disease = keyboard.nextLine();
        if (disease.equalsIgnoreCase("hiv")) {
            // Loop boolean variable
            boolean quit = false;
            // Main loop
            while (!quit) {
                System.out.println("What would you like to know about hiv?:");
                // Instance of ProgIntent class
                Backend backend = Backend.getInstance();
                // Get user utterance (u)
                System.out.print("U: ");
                String u = keyboard.nextLine();
                System.out.println(u);
                // Run query with u
                String response = backend.matchUtterance(u);
                // Add utterance and response to hashmap
                sessionMap.put(u, response);
                // Prompt user to quit
                System.out.println("Enter 'quit' or 'q' to quit; enter 'c' to continue:");
                String userChoice = keyboard.nextLine();
                if (userChoice.equalsIgnoreCase("q") || userChoice.equalsIgnoreCase("quit")) {
                    // Get final time
                    long finish = System.nanoTime();
                    long timeElapsed = finish - start;
                    backend.writeChatFile(sessionMap, timeElapsed);
                    quit = true;
                }
            }
        }
    }
}
