// Java program to Find
// the kth Permutation
// Sequence of first
// n natural numbers
import java.util.*;
class GFG{

// Function to find the index of
// number at first position of
// kth sequence of set of size n
static int findFirstNumIndex(int k,
							int n)
{
if (n == 1)
	return 0;
n--;

int first_num_index;

// n_actual_fact = n!
int n_partial_fact = n;

while (k >= n_partial_fact && n > 1)
{
	n_partial_fact = n_partial_fact *
					(n - 1);
	n--;
}

// First position of the
// kth sequence will be
// occupied by the number present
// at index = k / (n-1)!
first_num_index = k / n_partial_fact;

k = k % n_partial_fact;
return first_num_index;
}

// Function to find the
// kth permutation of n numbers
static String findKthPermutation(int n,
								int k)
{
// Store final answer
String ans = "";

HashSet<Integer> s = new HashSet<>();

// Insert all natural number
// upto n in set
for (int i = 1; i <= n; i++)
	s.add(i);

Vector<Integer> v = new Vector<>();
v.addAll(s);

// Mark the first position
int itr = v.elementAt(0);

// Subtract 1 to
// get 0 based
// indexing
k = k - 1;

for (int i = 0; i < n; i++)
{
	int index = findFirstNumIndex(k,
								n - i);
	
	// itr now points to the
	// number at index in set s
	if(index < v.size())
	{
	ans += ((v.elementAt(index).toString()));
	v.remove(index);
	}
	else
	ans += String.valueOf(itr + 2);

	// Remove current number
	// from the set
	itr = v.elementAt(0);
}
return ans;
}

// Driver code
public static void main(String[] args)
{
int n = 3, k = 4;
String kth_perm_seq = findKthPermutation(n, k);
System.out.print(kth_perm_seq + "\n");
}
}
