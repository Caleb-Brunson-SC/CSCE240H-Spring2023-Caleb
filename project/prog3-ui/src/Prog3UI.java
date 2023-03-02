import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Prog3UI Class.
 * @author Caleb Brunson.
 */

public class Prog3UI {

    public void findRegexMatch(String fileName, String userInput) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            boolean matchFound = false;
            while (sc.hasNextLine()) {
                // get the first word from each line
                String regex = sc.next();
                // check if there is a pattern match
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(userInput);
                matchFound = matcher.find();
                if (matchFound) {
                    String contentFile = sc.next();
                    printFile(contentFile);
                }
                // Check if a next line exists
                if (sc.hasNextLine()) {
                    // progress to next line
                    sc.nextLine(); 
                }
            }
            if (!matchFound) {
                System.out.println("Sorry, I do not understand that.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkFile(String fileName) {
        File newFile = new File(fileName); 

        if (newFile.length() == 0) { 
            System.out.println("Sorry! " + fileName + " file is empty.");
            return false;
        } else {
            return true;
        }
    }

    public void printFile(String fileName) {
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
