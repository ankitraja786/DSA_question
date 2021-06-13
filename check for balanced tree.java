class Height { 
    int height = 0; 
} 
class Tree
{ 
    Node root; 
    //Function to check for balanced tree.
    boolean isBalancedUtil(Node root, Height height) 
    { 
        //if root is null, we return true.
        if (root == null) { 
            height.height = 0; 
            return true; 
        } 
  
        Height lheight = new Height(), rheight = new Height(); 
        
        //calling the function isBalancedUtil recursively for the heights of 
        //left and right subtrees and storing the returned values in l and r.
        boolean l = isBalancedUtil(root.left, lheight); 
        boolean r = isBalancedUtil(root.right, rheight); 
        int lh = lheight.height, rh = rheight.height; 
  
        //height of current node is(max of height of left and right subtrees)+1.
        height.height = (lh > rh ? lh : rh) + 1; 
  
        //if difference between heights of left and right subtrees is 2 or 
        //more than 2 then this node is not balanced so we return false.
        if (Math.abs(lh -rh) >= 2) 
            return false; 
  
        //if this node is balanced and left and right subtrees are balanced 
        //then we return true.
        else
            return l && r; 
    }
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
        {
             Height height = new Height(); 
            return isBalancedUtil(root,height);
        }
    
    
}    

