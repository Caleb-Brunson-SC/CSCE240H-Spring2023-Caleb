## DOCUMENTATION.md
### Written by Caleb Brunson

#### Purpose
The goal of this project assignment is to extract data from static webpages related to the HIV disease. The program should perform the following tasks:
* Run in an infinite loop
* User can end the loop by typing "quit", "Quit", or "q"
* Take disease as input
* Take an information type as input
* Return content based on that known information
* Return all content if user requests everything
* Also, testing options and output should be stored in "test.txt" 

#### Project Organization
There are four directories contained in the prog3-ui directory. These are the following:
* data
    * This directory contains .txt files with data from CDC and webMD
* doc
    * This directory contains the 1-page report. **(you are here)**
* src
    * This directory contains the Prog3UI.java and Driver.java files
* test
    * This directory contains test.txt with input and output

#### Source Code Organization
* regex-hiv.txt
    * Tab delimited text file
    * First String is the regex pattern
    * Second String is the path to the corresponding file in the data directory
* Prog3UI.java
    * findRegexMath() method
        * Arguments: String fileName, String userInput
        * Returns: void
        * Finds which regex pattern matches with the user input
        * Calls printFile with the corresponding file path
    * checkFile() method
        * Arguments: String fileName
        * Returns: boolean
        * Returns false if the length of the file is zero (there are no characters present)
        * Returns true otherwise
    * printFile() method
        * Arguments: String fileName
        * Returns: void
        * Loops through the given file and prints all its content
    * printEverything() method
        * Arguments: String dirPath
        * Returns: void
        * Loops through all the files in the specified directory and calls printFile on each one
* Driver.java
    * Only method is main()
    * Contains infinite loop which prompts the user for input
    * Creates an instance of Prog3UI class
    * Calls required methods from Prog3UI

#### How to Use the Program
Upon running the Driver.java file, the program will prompt the user to type in "hiv" and then to enter any questions they have.

#### Test Case Used
The test case used was the input of "hiv" and "travel". The output was the After Travel content from the CDC webpage.