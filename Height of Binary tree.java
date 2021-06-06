class Solution
{
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        //if node is null, we return 0.
        if (node == null)
           return 0;

        //else we call the recursive function, height for left and right 
        //subtree and choose their maximum. we also add 1 to the result
        //which indicates height of root of the tree.
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }
}
