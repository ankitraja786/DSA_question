// Java program to find sum of all minimum and maximum
// elements Of Sub-array Size k.
import java.util.Deque;
import java.util.LinkedList;
public class Geeks {

	// Returns sum of min and max element of all subarrays
	// of size k
	public static int SumOfKsubArray(int arr[] , int k)
	{
		int sum = 0; // Initialize result

		// The queue will store indexes of useful elements
		// in every window
		// In deque 'G' we maintain decreasing order of
		// values from front to rear
		// In deque 'S' we maintain increasing order of
		// values from front to rear
		Deque<Integer> S=new LinkedList<>(),G=new LinkedList<>();

		// Process first window of size K
		int i = 0;
		for (i = 0; i < k; i++)
		{
			// Remove all previous greater elements
			// that are useless.
			while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast(); // Remove from rear

			// Remove all previous smaller that are elements
			// are useless.
			while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast(); // Remove from rear

			// Add current element at rear of both deque
			G.addLast(i);
			S.addLast(i);
		}

		// Process rest of the Array elements
		for ( ; i < arr.length; i++ )
		{
			// Element at the front of the deque 'G' & 'S'
			// is the largest and smallest
			// element of previous window respectively
			sum += arr[S.peekFirst()] + arr[G.peekFirst()];

			// Remove all elements which are out of this
			// window
			while ( !S.isEmpty() && S.peekFirst() <= i - k)
				S.removeFirst();
			while ( !G.isEmpty() && G.peekFirst() <= i - k)
				G.removeFirst();

			// remove all previous greater element that are
			// useless
			while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast(); // Remove from rear

			// remove all previous smaller that are elements
			// are useless
			while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast(); // Remove from rear

			// Add current element at rear of both deque
			G.addLast(i);
			S.addLast(i);
		}

		// Sum of minimum and maximum element of last window
		sum += arr[S.peekFirst()] + arr[G.peekFirst()];

		return sum;
	}

