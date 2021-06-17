class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root)
    {
        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        ArrayList<Integer> v = new ArrayList<Integer>();
    
        /* Pop all items one by one. Do following for every popped item
           a) print it
           b) push its right child
           c) push its left child
        Note that right child is pushed first so that left is processed first */
        while (stack.size() >0) {
            // Pop the top item from stack and print it
            Node node = stack.peek();
            v.add(node.data);
            stack.pop();
    
            // Push right and left children of the popped node to stack
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        return v;

    }
    
}

