import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ProgProcessor class which takes user input through CLI and provides text response about disease.
 * @author Caleb Brunson
 * https://www.w3schools.com/java/java_files_read.asp
 * https://stackoverflow.com/questions/36115552/getting-the-first-word-from-each-line
 */
public class ProgProcessor {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);  

        System.out.println("Welcome to the ProgProcessor!");
        System.out.println("Enter 'hiv' to learn about the disease:");
        String disease = keyboard.nextLine();

        if (disease.equalsIgnoreCase("hiv")) {
            String regexFile = "project\\prog2-processor\\data\\regex-hiv.txt";
            checkFile(regexFile);
            
            boolean quit = false;
            while(!quit) {
                System.out.println("What would you like to know about HIV?");
                String userInput = keyboard.nextLine();
                System.out.println("---------------------------------");
                findRegexMatch(regexFile, userInput);
                System.out.println("---------------------------------");
                System.out.println("Enter 'q' to quit or 'c' to continue:");
                String userChoice = keyboard.nextLine();
                if (userChoice.equalsIgnoreCase("q")) {
                    quit = true;
                }
            }
        } else {
            System.out.println("Sorry, invalid input");
        }
    }

    public static boolean checkFile(String fileName) {
        File newFile = new File(fileName); 

        if (newFile.length() == 0) { 
            System.out.println("Error: this file is empty.");
            return false;
        } else {
            return true;
        }
    }

    public static void findRegexMatch(String fileName, String userInput) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                // get the first word from each line
                String regex = sc.next();
                // check if there is a pattern match
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(userInput);
                boolean matchFound = matcher.find();
                if (matchFound) {
                    String contentFile = sc.next();
                    printFile(contentFile);
                } else {
                    System.out.println("Sorry, I do not understand that.");
                }
                // Check if a next line exists
                if (sc.hasNextLine()) {
                    // progress to next line
                    sc.nextLine(); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printFile(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);

            if (!checkFile(fileName)) {
                myReader.close();
                return;
            }

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
