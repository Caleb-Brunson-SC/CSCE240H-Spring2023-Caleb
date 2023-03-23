package src;
import java.io.File;
import java.util.HashMap;
/*
 * ProgIntent.java
 * Written by Caleb Brunson
 */

public class ProgIntent {
    private HashMap<String, File> regexMap = new HashMap<String, File>();
    private static ProgIntent progIntent;

    private ProgIntent() {
        regexMap = getRegexMap();
    }

    public static ProgIntent getInstance() {
        if(progIntent == null) {
            progIntent = new ProgIntent();
        }
        return progIntent;
    } 

    public HashMap<String, File> getRegexMap() {
        return regexMap;
    }

    public void matchUtterance(String u) {
        // 
    }
}
