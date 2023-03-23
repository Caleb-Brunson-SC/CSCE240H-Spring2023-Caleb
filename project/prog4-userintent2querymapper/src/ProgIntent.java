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
    private HashMap<String, File> dataMap = new HashMap<String, File>();
    private static ProgIntent progIntent;

    private ProgIntent() {
        this.dataMap = getDataMap();
    }

    public static ProgIntent getInstance() {
        if(progIntent == null) {
            progIntent = new ProgIntent();
        }
        return progIntent;
    } 

    public HashMap<String, File> getDataMap() {
        // https://www.javatpoint.com/how-to-read-csv-file-in-java
        try {
            HashMap<String, File> dataMap = new HashMap<String, File>();
           
            String dataDir = "project\\prog4-userintent2querymapper\\data";

            return dataMap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void matchUtterance(String u) {
        int j  = 0;
        for (String i : dataMap.keySet()) {
            System.out.println(j + "; key: " + i + " value: " + dataMap.get(i));
            j++;
          }
    }
}
