// Java program for finding postorder
// traversal of BST from preorder traversal

import java.util.*;

class Solution {
	static class INT {
		int data;
		INT(int d) { data = d; }
	}

	// Function to find postorder traversal from
	// preorder traversal.
	static void findPostOrderUtil(int pre[], int n,
								int minval, int maxval,
								INT preIndex)
	{

		// If entire preorder array is traversed then
		// return as no more element is left to be
		// added to post order array.
		if (preIndex.data == n)
			return;

		// If array element does not lie in range specified,
		// then it is not part of current subtree.
		if (pre[preIndex.data] < minval
			|| pre[preIndex.data] > maxval) {
			return;
		}

		// Store current value, to be printed later, after
		// printing left and right subtrees. Increment
		// preIndex to find left and right subtrees,
		// and pass this updated value to recursive calls.
		int val = pre[preIndex.data];
		preIndex.data++;

		// All elements with value between minval and val
		// lie in left subtree.
		findPostOrderUtil(pre, n, minval, val, preIndex);

		// All elements with value between val and maxval
		// lie in right subtree.
		findPostOrderUtil(pre, n, val, maxval, preIndex);

		System.out.print(val + " ");
	}

	// Function to find postorder traversal.
	static void findPostOrder(int pre[], int n)
	{

		// To store index of element to be
		// traversed next in preorder array.
		// This is passed by reference to
		// utility function.
		INT preIndex = new INT(0);

		findPostOrderUtil(pre, n, Integer.MIN_VALUE,
						Integer.MAX_VALUE, preIndex);
	}

	// Driver code
	public static void main(String args[])
	{
		int pre[] = { 40, 30, 35, 80, 100 };

		int n = pre.length;

		// Calling function
		findPostOrder(pre, n);
	}
}

