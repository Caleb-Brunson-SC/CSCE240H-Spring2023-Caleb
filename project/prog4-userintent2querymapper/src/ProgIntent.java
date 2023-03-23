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
    private HashMap<String, File> regexMap = new HashMap<String, File>();
    private static ProgIntent progIntent;

    private ProgIntent() {
        this.regexMap = getRegexMap();
    }

    public static ProgIntent getInstance() {
        if(progIntent == null) {
            progIntent = new ProgIntent();
        }
        return progIntent;
    } 

    public HashMap<String, File> getRegexMap() {
        // https://www.javatpoint.com/how-to-read-csv-file-in-java
        try {
            HashMap<String, File> regexMap = new HashMap<String, File>();
            String line = "";  
            String splitBy = ",";  

            BufferedReader br = new BufferedReader(new FileReader("regex-hiv.csv"));  
            while ((line = br.readLine()) != null)  {  
                String[] regexStrings = line.split(splitBy);    // use comma as separator  
                regexMap.put(regexStrings[0], new File(regexStrings[1]));
            }
            
            br.close();

            return regexMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void matchUtterance(String u) {
        for (String i : regexMap.keySet()) {
            System.out.println("key: " + i + " value: " + regexMap.get(i));
          }
    }
}
