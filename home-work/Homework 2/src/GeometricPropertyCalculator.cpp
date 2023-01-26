// GeometricPropertyCalculator.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Written by Caleb Brunson

#define _USE_MATH_DEFINES

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <cmath>
using namespace std;

// Check the file
void checkFileLength(string fileName) {
    // Adapted from https://stackoverflow.com/questions/49524249/counting-number-of-words-in-a-file-using-c

    int numLines = 0;
    int numWords = 0;
    string line;
    ifstream myfile(fileName);

    while (getline(myfile, line)) {
        ++numLines;
        stringstream lineStream(line);
        while (getline(lineStream, line, ' '))
        {
            ++numWords;
        }
    }

    if (numLines != 3) {
        cout << "Error: your file must have exactly 3 lines." << endl;
        exit(0);
    }
    
    if (numWords != 9) {
        cout << "Error: your file does not contain the correct amount of information." << endl;
        exit(0);
    }
}

// Read the File
string* readFile(string fileName) {
    // Adapted from https://www.geeksforgeeks.org/cpp-program-read-file-word-word/

    static string input[9];

    // filestream variable file
    fstream myfile;
    string word;
    myfile.open(fileName.c_str());

    // extracting words from the file
    int i = 0;
    while (myfile >> word) {
        // insert each word into the input array
        input[i] = word;
        ++i;
    }

    myfile.close();

    return input;
}

void calculateArea(string fileName, string input[]) {
    // Math adapted from http://www.quantstart.com/articles/Mathematical-Constants-in-C/

    double rLength = stod(input[1]);
    double rBreadth = stod(input[2]);
    double cRadius = stod(input[4]);

    double rArea = rLength * rBreadth;
    double cArea = M_PI * pow(cRadius, 2);

    ofstream myfile(fileName);
    myfile << "RECTANGLE AREA " << rArea << "\n";
    myfile << "CIRCLE AREA " << cArea << "\n";
    myfile << "TRIANGLE AREA null" << "\n";
    myfile.close();
}

void calculatePerimeter(string fileName, string input[]) {
    // Math adapted from http://www.quantstart.com/articles/Mathematical-Constants-in-C/

    double rLength = stod(input[1]);
    double rBreadth = stod(input[2]);
    double cRadius = stod(input[4]);
    double rSideOne = stod(input[6]);
    double rSideTwo = stod(input[7]);
    double rSideThree = stod(input[8]);

    double rPerimeter = 2 * (rLength + rBreadth);
    double cPerimeter = 2 * M_PI * cRadius;
    double tPerimeter = rSideOne + rSideTwo + rSideThree;

    ofstream myfile(fileName);
    myfile << "RECTANGLE PERIMETER " << rPerimeter << "\n";
    myfile << "CIRCLE PERIMETER " << cPerimeter << "\n";
    myfile << "TRIANGLE PERIMETER " << tPerimeter << "\n";
    myfile.close();
}

int main()
{
    cout << "Welcome to the Geometric Property Calculator!\n";

    cout << "Enter the path for your input.txt file: ";
    string inputFile; // "./data/input.txt"
    getline(cin, inputFile);

    checkFileLength(inputFile);

    string* input;
    input = readFile(inputFile);

    cout << "Enter the path for your output.txt file: ";
    string outputFile; // "./data/output.txt"
    getline(cin, outputFile);

    cout << "Enter 1 to calculate AREA and 2 to calculate PERIMETER: ";
    string userCalculationChoice;
    getline(cin, userCalculationChoice);

    // Call function based off user choice
    if (userCalculationChoice == "1") {
        calculateArea(outputFile, input);
    }
    else if (userCalculationChoice == "2") {
        calculatePerimeter(outputFile, input);
    }
    else {
        cout << "Invalid input!" << endl;
    }
    
}

