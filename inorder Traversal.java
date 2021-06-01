class Solution
{
    //Function to find the inorder traversal of the tree.
    void inorderUtil (Node root, ArrayList<Integer> res)
    {
        //inorder traversal works on Left Root Right.
          
        //if root is null then we simply return.
        if(root == null)
        {
           return;
        }        
        //first, we call the recursive function for left subtree.
        inorderUtil(root.left, res);
        //then we store the data at root in a list.
        res.add (root.data);
        //then we call the recursive function for right subtree.
        inorderUtil(root.right, res);
    }
    
    //Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root)
    {
       ArrayList<Integer> res = new ArrayList<Integer>(0); 
       inorderUtil (root, res);
       //returning the list.
       return res;
    }
    
    
}