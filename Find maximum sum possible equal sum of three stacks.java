// JAVA Code for Find maximum sum possible
// equal sum of three stacks
class GFG {
	
	// Returns maximum possible equal sum of three
	// stacks with removal of top elements allowed
	public static int maxSum(int stack1[], int stack2[],
							int stack3[], int n1, int n2,
											int n3)
	{
	int sum1 = 0, sum2 = 0, sum3 = 0;
	
	// Finding the initial sum of stack1.
	for (int i=0; i < n1; i++)
		sum1 += stack1[i];
	
	// Finding the initial sum of stack2.
	for (int i=0; i < n2; i++)
		sum2 += stack2[i];
	
	// Finding the initial sum of stack3.
	for (int i=0; i < n3; i++)
		sum3 += stack3[i];
	
	// As given in question, first element is top
	// of stack..
	int top1 =0, top2 = 0, top3 = 0;
	int ans = 0;
	while (true)
	{
		// If any stack is empty
		if (top1 == n1 || top2 == n2 || top3 == n3)
			return 0;
	
		// If sum of all three stack are equal.
		if (sum1 == sum2 && sum2 == sum3)
			return sum1;
		
		// Finding the stack with maximum sum and
		// removing its top element.
		if (sum1 >= sum2 && sum1 >= sum3)
			sum1 -= stack1[top1++];
		else if (sum2 >= sum1 && sum2 >= sum3)
			sum2 -= stack2[top2++];
		else if (sum3 >= sum2 && sum3 >= sum1)
			sum3 -= stack3[top3++];
	}
	}
	
	/* Driver program to test above function */
	public static void main(String[] args)
	{
		int stack1[] = { 3, 2, 1, 1, 1 };
		int stack2[] = { 4, 3, 2 };
		int stack3[] = { 1, 1, 4, 1 };
		
		int n1 = stack1.length;
		int n2 = stack2.length;
		int n3 = stack3.length;
		
		System.out.println(maxSum(stack1, stack2,
							stack3, n1, n2, n3));
	}
}
