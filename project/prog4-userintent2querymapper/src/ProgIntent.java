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

public class ProgIntent {
    private static final String REGEX_PATH = "project\\prog4-userintent2querymapper\\src\\regex-hiv.csv";
    private HashMap<String, File> regexMap = new HashMap<String, File>();
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

    public HashMap<String, File> getDataMap() {
        // https://stackoverflow.com/questions/4917326/how-to-iterate-over-the-files-of-a-certain-directory-in-java
        try {
            // Initalize hashmap
            HashMap<String, File> regexMap = new HashMap<String, File>();
            // Read CSV file and add key, value pairs to hashmap
            BufferedReader br = new BufferedReader(new FileReader(REGEX_PATH));
            String line = "";  
            String splitBy = ",";  
            while ((line = br.readLine()) != null) {  
                String[] regexStrings = line.split(splitBy); // use comma as separator  
                regexMap.put(regexStrings[0], new File(regexStrings[1]));
            }  
            br.close(); // close the buffered reader
            // Return the hashmap
            return regexMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void matchUtterance(String u) {
        try {
            // Split strin u into individual words
            String[] arrOfU = u.split(" ", -2);

            for (String i : regexMap.keySet()) {
                System.out.println(i);
                for (String word : arrOfU) {
                    System.out.println(word);
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
