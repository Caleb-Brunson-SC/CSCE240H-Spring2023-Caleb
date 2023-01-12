// QuickSortAlgo.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Written by Caleb Brunson
// Adapted from https://www.geeksforgeeks.org/quick-sort/

#include <iostream>
using namespace std;

// Swap function
void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

// Print array function
void printArray(int arr[], int size)
{
	for (int i = 0; i < size; i++)
		cout << arr[i] << " ";
	cout << " \n";
}

// arr = Array to be sorted
// left = starting index (low)
// right = ending index (high)

int partition(int arr[], int left, int right)
{
	int pivot = arr[right];
	int i = left - 1;

	for(int j = left; j <= right; j++)
	{
		// if the current element is smaller than the pivot, then increment index of smaller element
		if (arr[j] < pivot)
		{
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[right]);
	return (i + 1);
}

void quickSort(int arr[], int left, int right)
{
	if(left < right)
	{
		int partitionIndex = partition(arr, left, right);
		// Sort elements before and after partition seperately
		quickSort(arr, left, partitionIndex - 1);
		quickSort(arr, partitionIndex + 1, right);
	}
}

int main()
{
	// Program to sort numbers
	cout << "QuickSort Algorithm to Sort Numbers" << endl;

	// Construct the array
	int arr[] = {42, 36, 10, 1, 50, 4, 3, 87, 2};

	// Find the length of the array by dividing the total number of bytes in the array by the size of one element
	int n = sizeof(arr) / sizeof(arr[0]);

	// Print the input (unsorted) array
	cout << "Input (unsorted) Array:" << endl;
	printArray(arr, n);

	// Sort the array
	quickSort(arr, 0, n - 1);

	// Print the output (sorted) array
	cout << "\n\nOutput (sorted) Array:" << endl;
	printArray(arr, n);

	return 0;
}
