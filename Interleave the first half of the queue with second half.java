
Interleave the first half of the queue with second half

Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.

Only a stack can be used as an auxiliary space.

Examples:

Input :  1 2 3 4
Output : 1 3 2 4

Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20



=====================================================
// Java program to interleave
// the first half of the queue
// with the second half
import java.util.*;

class GFG
{

// Function to interleave the queue
static void interLeaveQueue(Queue<Integer>q)
{
	// To check the even number of elements
	if (q.size() % 2 != 0)
		System.out.println("Input even number of integers." );

	// Initialize an empty stack of int type
	Stack<Integer> s = new Stack<>();
	int halfSize = q.size() / 2;

	// Push first half elements into the stack
	// queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
	for (int i = 0; i < halfSize; i++)
	{
		s.push(q.peek());
		q.poll();
	}

	// enqueue back the stack elements
	// queue: 16 17 18 19 20 15 14 13 12 11
	while (!s.empty())
	{
		q.add(s.peek());
		s.pop();
	}

	// dequeue the first half elements of queue
	// and enqueue them back
	// queue: 15 14 13 12 11 16 17 18 19 20
	for (int i = 0; i < halfSize; i++)
	{
		q.add(q.peek());
		q.poll();
	}

	// Again push the first half elements into the stack
	// queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
	for (int i = 0; i < halfSize; i++)
	{
		s.push(q.peek());
		q.poll();
	}

	// interleave the elements of queue and stack
	// queue: 11 16 12 17 13 18 14 19 15 20
	while (!s.empty())
	{
		q.add(s.peek());
		s.pop();
		q.add(q.peek());
		q.poll();
	}
}

// Driver code
public static void main(String[] args)
{
	Queue<Integer> q = new java.util.LinkedList<>();
	q.add(11);
	q.add(12);
	q.add(13);
	q.add(14);
	q.add(15);
	q.add(16);
	q.add(17);
	q.add(18);
	q.add(19);
	q.add(20);
	interLeaveQueue(q);
	int length = q.size();
	for (int i = 0; i < length; i++)
	{
		System.out.print(q.peek() + " ");
		q.poll();
	}
}
}

