
class Tree
{
    int max_level = 0;
    
    //Function to get the left view of the binary tree.
    void leftViewUtil(ArrayList<Integer> result, Node node, int level)
    {
        //if root is null, we simply return.
        if (node==null) return;
        
        //if this is the first node of its level then it is in the left view.
        if (max_level < level)
        {
            //storing data of current node in list.
            result.add(node.data);
            max_level = level;
        }
        
        //calling function recursively for left and right 
        //subtrees of current node.
        leftViewUtil(result, node.left, level+1);
        leftViewUtil(result, node.right, level+1);
    }
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
		leftViewUtil(result, root, 1);
		//returning the list.
		return result;
    }
}

