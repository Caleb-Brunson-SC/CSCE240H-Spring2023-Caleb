# doc.md
# Written by Caleb Brunson

#### Purpose
The goal of this project was to adapt the chatbot system to handle varying user inputs. The program must:
* Take an utterance from the User.
* Match the support query that is closest to the utterance.
* If the confidence level is above a threshold, then run the query.
    * Otherwise, ask the user to ask again.

#### Source Code Organization
There are four directories contained in the prog3-ui directory. These are the following:
* data
    * This directory contains .txt files with data from CDC and webMD.
* doc
    * This directory contains the 1-page report.
* src
    * This directory contains the ProgIntent.java, Driver.java, and regex-hiv.csv files.
    * ProgIntent.java contains the backend code to match, test confidence level, and run a query.
    * Driver.java contains the frontend code for the command-line interface (CLI)
    * regex-hiv.csv file contains supported queries and content file paths
* test
    * This directory contains log.txt with sample user interaction and output.

#### How to Use the Program
Upon running the Driver.java file, the program will prompt the user to type in "hiv" and then to enter any questions they have.

#### Test Case Used
The two test cases (user utterances) used were:
1. "what are the effects on the skeletal system?"
2. "who is john marry ables?"
The output from these utterances is in the log.txt file.