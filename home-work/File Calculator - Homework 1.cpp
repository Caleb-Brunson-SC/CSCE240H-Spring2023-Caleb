// File Calculator - Homework 1.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Written by Caleb Brunson

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Check the file
void checkFileLength(string fileName) {
    int numberOfLines = 0;
    string line;
    ifstream myfile(fileName);

    while (getline(myfile, line))
        ++numberOfLines;

    if (numberOfLines != 3) {
        cout << "Error: your file must have exactly 3 lines." << endl;
        exit(0);
    }
}

// Read the File
string* readFile(string fileName) {
    static string input[3];
    string line;
    ifstream myfile(fileName);
    if (myfile.is_open())
    {
        for (int i = 0; i < 3; i++)
        {
            getline(myfile, line);
            input[i] = line;
        }
        myfile.close();
    }
    else cout << "Unable to open file";

    return input;
}

void calculate(string operand, int numberOne, int numberTwo, string fileName) {
    if (operand == "add") {
        int result = numberOne + numberTwo;
        ofstream myfile(fileName);
        myfile << "The result of an add on " << numberOne << " and " << numberTwo << "\n";
        myfile << result;
        myfile.close();
    }
    else if (operand == "subtract") {
        int result = numberOne - numberTwo;
        ofstream myfile(fileName);
        myfile << "The result of an subtract on " << numberOne << " and " << numberTwo << "\n";
        myfile << result;
        myfile.close();
    }
    else if (operand == "multiply") {
        int result = numberOne * numberTwo;
        ofstream myfile(fileName);
        myfile << "The result of an multiply on " << numberOne << " and " << numberTwo << "\n";
        myfile << result;
        myfile.close();
    }
    else if (operand == "divide") {
        double result = (double) numberOne / (double) numberTwo;
        ofstream myfile(fileName);
        myfile << "The result of an divide on " << numberOne << " and " << numberTwo << "\n";
        myfile << result;
        myfile.close();
    }
    else
        cout << "Error: improper input." << "\n";
}

int main()
{
    std::cout << "Welcome to zee calculatorrrr!\n" << "\n";

    string inputFile; // "./data/example.txt"

    cout << "Enter the path for your input.txt file: ";
    getline(cin, inputFile);

    checkFileLength(inputFile);
    
    string* input;
    input = readFile(inputFile);

    string operand = input[0];
    int numberOne = stoi(input[1]);
    int numberTwo = stoi(input[2]);

    string outputFile;
    cout << "Enter the path for your output.txt file: ";
    getline(cin, outputFile);

    calculate(operand, numberOne, numberTwo, outputFile);

    return 0;
}
