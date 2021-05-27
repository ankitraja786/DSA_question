// Java program to find min sum of squares
// of characters after k removals
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;
public class GFG {

	static final int MAX_CHAR = 26;

	// Main Function to calculate min sum of
	// squares of characters after k removals
	static int minStringValue(String str, int k)
	{
		int l = str.length(); // find length of string

		// if K is greater than length of string
		// so reduced string will become 0
		if (k >= l)
			return 0;

		// Else find Frequency of each character and
		// store in an array
		int[] frequency = new int[MAX_CHAR];
		for (int i = 0; i < l; i++)
			frequency[str.charAt(i) - 'a']++;

		// creating a priority queue with comparator
		// such that elements in the queue are in
		// descending order.
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		// Push each char frequency into a priority_queue
		for (int i = 0; i < MAX_CHAR; i++) {
			if (frequency[i] != 0)
				q.add(frequency[i]);
		}

		// Removal of K characters
		while (k != 0) {
			// Get top element in priority_queue,
			// remove it. Decrement by 1 and again
			// push into priority_queue
			q.add(q.poll() - 1);
			k--;
		}

		// After removal of K characters find sum
		// of squares of string Value
		int result = 0; // Initialize result
		while (!q.isEmpty()) {
			result += q.peek() * q.poll();
		}

		return result;
	}

	// Driver Code
	public static void main(String args[])
	{
		String str = "abbccc"; // Input 1
		int k = 2;
		System.out.println(minStringValue(str, k));

		str = "aaab"; // Input 2
		k = 2;
		System.out.println(minStringValue(str, k));
	}
}
