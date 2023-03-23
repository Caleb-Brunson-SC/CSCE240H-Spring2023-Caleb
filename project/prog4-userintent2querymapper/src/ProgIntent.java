package src;
import java.io.File;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.HashMap;
/*
 * ProgIntent.java
 * Written by Caleb Brunson
 */
import java.util.Scanner;

public class ProgIntent {
    private static final String REGEX_PATH = "project\\prog4-userintent2querymapper\\src\\regex-hiv.csv";
    private HashMap<String, String> regexMap = new HashMap<String, String>();
    private static ProgIntent progIntent;

    private ProgIntent() {
        this.regexMap = getDataMap();
    }

    public static ProgIntent getInstance() {
        if(progIntent == null) {
            progIntent = new ProgIntent();
        }
        return progIntent;
    } 

    public HashMap<String, String> getDataMap() {
        // https://stackoverflow.com/questions/4917326/how-to-iterate-over-the-files-of-a-certain-directory-in-java
        try {
            // Initalize hashmap
            HashMap<String, String> regexMap = new HashMap<String, String>();
            // Read CSV file and add key, value pairs to hashmap
            BufferedReader br = new BufferedReader(new FileReader(REGEX_PATH));
            String line = "";  
            String splitBy = ",";  
            while ((line = br.readLine()) != null) {  
                String[] regexStrings = line.split(splitBy); // use comma as separator  
                regexMap.put(regexStrings[0], regexStrings[1]);
            }  
            br.close(); // close the buffered reader
            // Return the hashmap
            return regexMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkFile(String fileName) {
        File newFile = new File(fileName); 

        if (newFile.length() == 0) { // this line assumes that a file with no characters is empty
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

    public void matchUtterance(String u) {
        try {
            // Split strin u into individual words
            String[] arrOfU = u.split(" ", -2);

            double lowestPercent = 0.0;
            String resultFilePath = null;

            for (String i : regexMap.keySet()) {
                String[] regexWords = i.split("\\s+");
                int regexWordCount = regexWords.length;

                int matchCount = 0;

                for (String uWord : arrOfU) {
                    for (String regexWord : regexWords) {
                        if (uWord.equalsIgnoreCase(regexWord)) {
                            matchCount++;
                        }
                    }
                }

                double matchPercent = matchCount / ((float)regexWordCount);
                
                if (matchPercent > lowestPercent) {
                    lowestPercent = matchPercent;
                    resultFilePath = regexMap.get(i);
                }
            }

            if (lowestPercent > 0.7) {
                System.out.println(lowestPercent + " " + resultFilePath);
                printFile(resultFilePath);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
