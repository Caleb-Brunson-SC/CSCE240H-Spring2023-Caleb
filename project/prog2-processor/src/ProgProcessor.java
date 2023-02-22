import java.util.*;
import java.io.*;

/**
 * ProgProcessor class which takes user input through CLI and provides text response about disease.
 * @author Caleb Brunson
 * https://www.w3schools.com/java/java_files_read.asp
 * https://stackoverflow.com/questions/36115552/getting-the-first-word-from-each-line
 */
public class ProgProcessor {
    public static void main(String[] args) {
        System.out.println("Welcome to the ProgProcessor!");

        String regexFile = "project\\prog2-processor\\data\\regex-hiv.txt";
        checkFile(regexFile);
        findRegexMatch(regexFile);


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

    public static void findRegexMatch(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String regex = sc.next();// get the first word from each line
                System.out.println(regex);

                if (regex.equalsIgnoreCase("after|travel")) {
                    String contentFile = sc.next();
                    System.out.println(contentFile);
                    printFile(contentFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printFile(String fileName) {
        try {
            File myFile = new File("filename.txt");
            Scanner myReader = new Scanner(myFile);

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
