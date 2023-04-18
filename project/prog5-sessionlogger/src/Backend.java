package src;
import java.io.File;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Backend {
    private static final String REGEX_PATH = "project\\prog5-sessionlogger\\src\\regex-hiv.csv";
    private static final String CHAT_SESSIONS_DIR_PATH = "project\\prog5-sessionlogger\\data\\chat_sessions\\";
    private static final String STATISTICS_PATH = "project\\prog5-sessionlogger\\data\\chat_statistics.csv";
    private HashMap<String, String> regexMap = new HashMap<String, String>();
    private static Backend backend;
    private ArrayList<String> chatFiles;

    private Backend() {
        this.regexMap = getDataMap();
        this.chatFiles = new ArrayList<String>();
    }

    public static Backend getInstance() {
        if(backend == null) {
            backend = new Backend();
        }
        return backend;
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
        try {
            File newFile = new File(fileName); 

            if (newFile.length() == 0) { // this line assumes that a file with no characters is empty
                System.out.println("Sorry! " + fileName + " file is empty.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public String printFile(String fileName) {
        try {
            String fileText = "";
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);

            if (!checkFile(fileName)) {
                myReader.close();
            }

            while (myReader.hasNextLine()) {
                fileText = fileText + myReader.nextLine();
            }

            return fileText;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

    public String matchUtterance(String u) {
        try {
            // Split strin u into individual words
            String[] arrOfU = u.split(" ", -2);

            double lowestPercent = 0.0;
            String systemResponse = null;
            String query = null;
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
                    query = i;
                    resultFilePath = regexMap.get(i);
                }
            }

            if (lowestPercent > 0.7) {
                systemResponse = "-----------------------------------------------------------------------\n" + 
                "S: " + printFile(resultFilePath) + "\nSource: " + resultFilePath + "\n" +
                "-----------------------------------------------------------------------";
            } else if (lowestPercent > 0) {
                systemResponse = "-----------------------------------------------------------------------\n" + 
                "S: Sorry, I do not know that information.\nHere is my guess: " + query + "\n" + 
                printFile(resultFilePath) + "\nSource: " + resultFilePath + "\n" +
                "Did I answer this correctly?\n" +
                "-----------------------------------------------------------------------";
            } else {
                systemResponse = "Sorry, I do not know that information.";
            }

            // print out systemResponse
            System.out.println(systemResponse);
            // Add resultFilePath to chatFiles
            chatFiles.add(resultFilePath);

            return systemResponse;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeChatFile(HashMap<String, String> sessionMap, double sessionDuration) {
        try {
            // https://www.javatpoint.com/java-get-current-date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now).toString();
            File myObj = new File(CHAT_SESSIONS_DIR_PATH + date + "_" + sessionDuration +  ".txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(myObj);
                
                int count = 0;
                // write utterances and responses
                for (String utterance : sessionMap.keySet()) {
                    myWriter.write(utterance);
                    myWriter.write(sessionMap.get(utterance));
                    count++;
                }
                
                // write statistics
                myWriter.write("Statistics; # of user utterances: " + count + "; # of system utterances: " + count
                + "; Time Duration of Sessions: " + sessionDuration);

                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}