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
    * This directory contains two sub-directories: cdc-content and webmd-content. They each contain their own .txt files
* doc
    * This directory contains the 1-page report. **(you are here)**
* src
    * This directory contains the ProgProcessor.java code
* test
    * This directory contains text_output.txt with input and output

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
* 

#### How to Use The Program
The program will complete automatically once it is run. 

#### Test Cases Used
