class Main
{
    // Recursive function to print a complete binary search tree in increasing order
    public static void printIncreasingOrder(int[] arr, int low, int high)
    {
        if (low > high) {
            return;
        }
 
        // recur for the left subtree
        printIncreasingOrder(arr, low*2 + 1, high);
 
        // print the root node
        System.out.print(arr[low] + " ");
 
        // recur for the right subtree
        printIncreasingOrder(arr, low*2 + 2, high);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 15, 10, 20, 8, 12, 18, 25 };
        printIncreasingOrder(arr, 0, arr.length - 1);
    }
}