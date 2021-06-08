class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Recursive function to perform postorder traversal on the tree
    public static void postorder(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }
    
        // Traverse the left subtree
        postorder(root.left);
    
        // Traverse the right subtree
        postorder(root.right);
    
        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        postorder(root);
    }
}

