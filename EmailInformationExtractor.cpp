// EmailInformationExtractor.cpp : This file contains the 'main' function. Program execution begins and ends there.
// https://cplusplus.com/forum/general/11460/#msg54095
// https://stackoverflow.com/questions/9670396/exception-handling-and-opening-a-file
// https://stackoverflow.com/questions/33152992/find-in-c-if-a-line-from-file-contains-a-specific-character

#include <iostream>
#include <fstream>
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

    OutlookHeaderType outlook;
    outlook.printMessage("outlookheader.txt", "To");
}
