// Java implementation to find the first negative
// integer in every window of size k
import java.util.*;

class solution
{

// function to find the first negative
// integer in every window of size k
static void printFirstNegativeInteger(int arr[], int n, int k)
{
	// flag to check whether window contains
	// a negative integer or not
	boolean flag;
	
	// Loop for each subarray(window) of size k
	for (int i = 0; i<(n-k+1); i++)		
	{
		flag = false;

		// traverse through the current window
		for (int j = 0; j<k; j++)
		{
			// if a negative integer is found, then
			// it is the first negative integer for
			// current window. Print it, set the flag
			// and break
			if (arr[i+j] < 0)
			{
				System.out.print((arr[i+j])+" ");
				flag = true;
				break;
			}
		}
		
		// if the current window does not
		// contain a negative integer
		if (!flag)
			System.out.print("0"+" ");
	}
}

// Driver program to test above functions
public static void main(String args[])
{
	int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
	int n = arr.length;
	int k = 3;
	printFirstNegativeInteger(arr, n, k);
	
}
}
