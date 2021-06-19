// Java program to count all
// duplicates from string using
// hashing

public class GFG {
	static final int NO_OF_CHARS = 256;

	/* Fills count array with
	frequency of characters */
	static void fillCharCounts(String str,
								int[] count)
	{
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}

	/* Print duplicates present
	in the passed string */
	static void printDups(String str)
	{
		// Create an array of size
		// 256 and fill count of
		// every character in it
		int count[] = new int[NO_OF_CHARS];
		fillCharCounts(str, count);

		for (int i = 0; i < NO_OF_CHARS; i++)
			if (count[i] > 1)
				System.out.println((char)(i) +
						", count = " + count[i]);
	}

	// Driver Method
	public static void main(String[] args)
	{
		String str = "test string";
		printDups(str);
	}
}
