
class Tree
{
    //Function to find the postorder traversal of the tree.
    void postOrderUtil (Node root, ArrayList<Integer> res)
    {
        //postorder traversal works on Left Right Root.
          
        //if root is null then we simply return.
        if(root==null)
           return;
           
       //first, we call the recursive function for left subtree.
       postOrderUtil(root.left, res);
       //then we call the recursive function for right subtree.
       postOrderUtil(root.right, res);
       //then we store the data at root in a list.
       res.add (root.data);
    }
    
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> res = new ArrayList<Integer>(0); 
       postOrderUtil (root, res);
       //returning the list.
       return res;
    }
}

