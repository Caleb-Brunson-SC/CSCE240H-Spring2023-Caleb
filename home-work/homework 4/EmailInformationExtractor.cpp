// Homework 4.cpp : This file contains the 'main' function. Program execution begins and ends there.
// https://cplusplus.com/forum/general/11460/#msg54095
// https://stackoverflow.com/questions/9670396/exception-handling-and-opening-a-file
// https://stackoverflow.com/questions/33152992/find-in-c-if-a-line-from-file-contains-a-specific-character

#include <iostream>
#include <fstream>
#include <map>
#include <string>
#include <vector>
using namespace std;




class BaseEmailHeaderType {
protected:
    vector<string> parts;
public:
    BaseEmailHeaderType() {
        vector<string> newParts{ "Recieved", "Content-Type", "From", "To", "CC", "Subject", "Date", "Message-ID", "References" };
        parts = newParts;
    };
    BaseEmailHeaderType(vector<string> newParts) {
        parts = newParts;
    };
    void printParts() {
        for (auto i = parts.begin(); i != parts.end(); ++i)
            cout << *i << " ";
    };
    void printMessage(string fileName, string message) {
        ifstream file;
        file.exceptions(ifstream::badbit);
        try {
            file.open(fileName);
            string line;
            while (getline(file, line)) {
                if (line.find(message) != string::npos) {
                    cout << line << endl;
                }
            }
        }
        catch (const ifstream::failure& e) {
            cout << "Exception opening/reading file";
        }

        file.close();
    };
};



class GmailHeaderType: public BaseEmailHeaderType {
public:
    GmailHeaderType() {
        vector<string> newParts{ "Delivered-To", "Recieved", "X-Google-Stmp-Source", "From", "Content-Type", "Date", 
            "Reply-To", "To", "Message-ID", "Subject", "MIME-Version", "Content-Transfer" };
        parts = newParts;
    };
    GmailHeaderType(vector<string> newParts) {
        parts = newParts;
    };
};

class OutlookHeaderType : public BaseEmailHeaderType {
public:
    OutlookHeaderType() {
        vector<string> newParts{ "Received", "Authentication-Results", "Content-Type", "Content-Transfer-Encoding", 
            "From", "To", "CC", "Subject", "Thread-Topic", "Thread-Index", "Date", "Message-ID", "References", 
            "In-Reply-To", "Accept-Language", "Content-Language", "X-MS-Has-Attach", "X-MS-Exchange-Organization-SCL" };
        parts = newParts;
    };
    OutlookHeaderType(vector<string> newParts) {
        parts = newParts;
    };
};

int main()
{
    bool quit = false;
    while (!quit) {
        cout << "*************Welcome to the Email Extraction Program*************" << endl;
        cout << "* Enter 'gmail' to extract from the gmail header file" <<
                "\n* Enter 'outlook' to extract from the outlook header file" << endl;
        string headerChoice;
        cin >> headerChoice;
        if (headerChoice.compare("gmail") == 0) {
            GmailHeaderType gmail;
            cout << "Would you like to see the list of accepted part names?" << endl;
            cout << "* Enter 'y' for yes" << 
                "\n* Enter 'n' for no" << endl;
            string seePartsChoice;
            cin >> seePartsChoice;
            if (seePartsChoice.compare("y") == 0) {
                gmail.printParts();
            }
            
            cout << "Please enter the part name you would like to return a message value for:" << endl;
            string inputPart;
            cin >> inputPart;
            gmail.printMessage("gmailheader.txt", inputPart);
        }
        else if (headerChoice.compare("outlook") == 0) {
            OutlookHeaderType outlook;
            cout << "Would you like to see the list of accepted part names?" << endl;
            cout << "* Enter 'y' for yes" <<
                "\n* Enter 'n' for no" << endl;
            string seePartsChoice;
            cin >> seePartsChoice;
            if (seePartsChoice.compare("y") == 0) {
                outlook.printParts();
            }

            cout << "Please enter the part name you would like to return a message value for:" << endl;
            string inputPart;
            cin >> inputPart;
            outlook.printMessage("outlookheader.txt", inputPart);
        }
        else {
            cout << "Invalid Input" << endl;
        }


        cout << "Enter 'q' to quit or 'c' to continue" << endl;
        string quitChoice;
        cin >> quitChoice;
        if (quitChoice.compare("q") == 0) {
            quit = true;
        }
        else if (quitChoice.compare("c") == 0) {
            quit = false;
        }
        else {
            cout << "Invalid Input" << endl;
        }
    }


    
}
