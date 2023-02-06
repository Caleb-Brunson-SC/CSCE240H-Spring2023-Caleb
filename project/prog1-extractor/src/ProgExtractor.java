import java.util.*;
import java.io.*;

/*
 * Helpful Resources
 * https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
 * https://www.w3schools.com/java/java_files_read.asp
 * https://www.geeksforgeeks.org/java-program-to-count-the-number-of-lines-words-characters-and-paragraphs-in-a-text-file/
 */

public class ProgExtractor {

    public static void main(String[] args) {
        System.out.println("Welcome to the ProgExtractor!"
        +"\nThis program utilizes static webpage content (.txt files) contained in the src subfolder.");

        File folder = new File("project/prog1-extractor/data");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("\n----------------------------\n" + "Current file: " + file.getName());
                boolean fileStatus = checkFile(file.getPath());

                if (fileStatus) {
                    calculateFileStatistics(file.getPath());
                    formatOutputFile(file.getPath());
                } else {
                    System.out.println("Skipping file...");
                    continue;
                }

                System.out.println("----------------------------");
            }
        }
    }

    private static boolean checkFile(String fileName) {
        File newFile = new File(fileName); 

        if (newFile.length() == 0) { 
            System.out.println("Error: this file is empty.");
            return false;
        } else {
            return true;
        }
    }

    private static void calculateFileStatistics(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);

            int lineCount = 0;
            int wordCount = 0;
            int characterCount = 0;

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                lineCount++;

                if (!line.equals("")) {
                    characterCount += line.length();
                    String words[] = line.split("\\s+");
                    wordCount += words.length;
                }
            }

            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + characterCount);

            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void formatOutputFile(String fileName) {
        //TODO
    }



}