# doc.md
# Written by Caleb Brunson

#### Purpose
* The goal of the project is to record the chat which the system has with the user. 
* Chat sessions will be recorded and stored in .txt files with chat statistics.

#### Source Code Organization
* data:
    * This directory contains .txt files with data from CDC and webMD. There is also a file named chat_statistics.csv where each row contains a log file and the following statistics:
    * Session number
    * Number of user utterances
    * Number of system utterances
    * Time taken
* data/chat_sessions:
    * This subdirectory to the data directory contains .txt files which log the user's sessions with the chatbot.
* doc: 
    * This directory contains the 1-page report.
* src:
    * This directory contains the Backend.java, Driver.java, and regex-hiv.csv files.

#### test
This directory contains session-log.txt with sample user interaction and output.

#### How to Use the Program
Run the Driver.java file and answer the system prompts.

#### Test Case Used
U: What should I do after travel?
U: What are the effects on the skeletal system?