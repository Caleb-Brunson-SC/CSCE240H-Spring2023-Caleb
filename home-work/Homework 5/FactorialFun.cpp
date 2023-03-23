// FactorialFun.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Written by Caleb Brunson
//

#include <iostream>
#include <chrono>
#include <string>
#include <sstream>
#include <map>
using namespace std;

int getNumOfWords(string input) {
    int words = 1;
    int length = input.size();
    for (int i = 0; i < length; i++) {
        if (input[i] == ' ') {
            words++;
        }
    }
    return words;
}

void checkInput(string input) {
    try {
        // Check if String is empty
        if (input.empty()) {
            throw "String is empty.";
        }
        // Check that String has no less than and no more than 2 words
        int words = getNumOfWords(input);
        if (words > 2) {
            throw "String does not have 1 or 2 numbers.";
        }
    }
    catch (const char* msg) {
        cerr << msg << endl;
    }
}

int convertStringToInt(string input) {
    // https://stackoverflow.com/questions/1243428/convert-string-to-int-with-bool-fail-in-c
    map<string, int> wordNumbers{ { "one", 1}, {"two", 2}, {"three", 3}, {"four", 4}, {"five", 5}, {"six", 6},
        {"seven", 7}, {"eight", 8}, {"nine", 9}, {"ten", 10} };
    try {
        stringstream ss(input);
        int i;
        // Check if word can 
        if (wordNumbers.find(input) != wordNumbers.end()) {
            return wordNumbers[input];
        }
        else if (!((ss >> i).fail() || !(ss >> ws).eof())) {
            return stoi(input);
        }
        else {
            throw bad_cast();
        }
    }
    catch (bad_cast) {
        cerr << "Bad type casting from string to int." << endl;
    }
}

long factorial(long n) {
    // https://www.geeksforgeeks.org/program-for-factorial-of-a-number/
    if (n == 0 || n == 1)
        return 1;
    return n * factorial(n - 1);
}

int combination(int n, int r) {
    // https://www.geeksforgeeks.org/program-to-calculate-value-of-ncr-using-recursion/
    if (n < r) {
        return 0;
    }
    if (r == 0) {
        return 1;
    }
    if (r == 1) {
        return n;
    }
    if (n == 1) {
        return 1;
    }
    return combination(n - 1, r - 1) + combination(n - 1, r);
}


int main()
{
    cout << "Welcome to Factorial Fun!\nPlease enter 1 number to calculate Factorial or 2 numbers to calculate the Combinatorial." << endl;
    cout << "Note: program only supports word-numbers from 'one' to 'ten'." << endl;

    while (true) {
        string input;
        getline(cin, input);
        checkInput(input);

        int words = getNumOfWords(input);
        if (words == 1) {
            int n = convertStringToInt(input);
            // Calculate and Time
            auto start = chrono::steady_clock::now();
            long facResult = factorial(n);
            auto end = chrono::steady_clock::now();

            cout << n << "! = " << facResult << "\n";

            cout << "Elapsed time in nanoseconds: "
                << chrono::duration_cast<chrono::nanoseconds>(end - start).count()
                << " ns" << endl;
        }
        else {
            // Split string then convert each to integers
            string arr[2];
            int i = 0;
            stringstream ssin(input);
            while (ssin.good() && i < 2) {
                ssin >> arr[i];
                ++i;
            }
            int n = convertStringToInt(arr[0]);
            int r = convertStringToInt(arr[1]);
            // Calculate and Time
            auto start = chrono::steady_clock::now();
            int combResult = combination(n, r);
            auto end = chrono::steady_clock::now();

            cout << "C(" << n << ", " << r << ") = " << combResult << "\n";

            cout << "Elapsed time in nanoseconds: "
                << chrono::duration_cast<chrono::nanoseconds>(end - start).count()
                << " ns" << endl;
        }
    }
}

