class Tree
{

    // Diagonal sum method
    public ArrayList<Integer> diagonal(Node root)
    {
        // Queue which stores tree nodes
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // Loop while the queue is not empty
        ArrayList<Integer> diagonalNode = new ArrayList<Integer>();
        while (!queue.isEmpty())
        {
            // Remove the front tree node from queue.
            Node curr = queue.remove();


            while (curr != null)
            {
				
                diagonalNode.add(curr.data);
                // If for any node the left child is not null add
                // it to the queue for future processing.
                if (curr.left != null)
                {
                    queue.add(curr.left);
                }

                // Move to the current node's right child.
                curr = curr.right;
            }
        }
        return diagonalNode;
    }
}

