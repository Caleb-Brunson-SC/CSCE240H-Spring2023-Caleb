## Programming Assingment #1
### Written by Caleb Brunson

#### Purpose
The goal of this project assignment is to extract data from static webpages related to the HIV disease. The program should perform the following tasks:
1. Take disease as input
2. Read content about the disease
    * I chose to use a local text version of the webpage content
3. Report statistics on each webpage. I chose to report number of:
    * Lines
    * Words
    * Chars
4. Write content formatted with indentation to an output file

#### Project Organization
There are four directories contained in the prog1-extractor directory. These are the following:
* data
    * This directory contains ten input (.txt) files.
* doc
    * This directory contains the 1-page report **(you are here)**.
* src
    * This directory contains the ProgExtractor.java source code.
* test
    * This directory contains ten (.txt) output files and two .png images of console output.

#### Source Code Organization
The ProgExtractor.java class contains four methods:
* main() 
    * Returns void
    * Default Java main() method
    * Prompts the user with a greeting and basic information about the purpose of the file
    * Iterates through an array of .txt files in the data directory containing webpage content about HIV
        * One .txt file from CDC
        * Eight .txt files from webmd
        * One junk .txt file named bob.txt for testing 
    * During the iteration the method does the following:
        1. Call the checkFile() method
            * As long as the file is not empty, the program proceeds with the next two steps
        2. Call the calculateFileStatistics() method
        3. Call the formatOutputFile() method
* checkFile() 
    * Returns a boolean value representing the status of the file
        * TRUE = good
        * FALSE = bad
    * Uses an if-else statement to check the length of the file
        * If the file is empty, return false
        * Else, return true
* calculateFileStatistics()
    * Returns void
    * Iterates over every line in the file
    * Counts the number of lines
    * Counts the number of words
        * Words are seperated by one or more spaces
    * Counts the number of characters
    * Prints all the statistics
* formatOutputFile()
    * Returns void 
    * Creates an output file for a given input file in the test directory
    * Adds a tab indentation to the beginning of the first line of a paragraph

#### How to Use The Program
The program will complete automatically once it is run. However, non-empty .txt files must be present in the data directory for the program to operate successfully. 

#### Test Cases Used
I tested the program using the following text files:
* One .txt file from CDC
* Eight .txt files from webmd
* One junk .txt file named bob.txt for testing

The result of the testing can be found in the test directory. There is no output-bob.txt file in the directory because the bob.txt file in the data directory is empty. Also, the prog1-extractor-output1.png and prog1-extractor-output2.png show the console output after the test. 