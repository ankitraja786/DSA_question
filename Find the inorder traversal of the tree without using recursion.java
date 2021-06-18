class Tree
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
    
        Stack <Node> s = new Stack<Node>();
        ArrayList<Integer> v = new ArrayList <Integer>();
        Node curr = root;
        while(curr!= null || s.size() >0)
        {
            while(curr!=null)
            {
            s.push(curr);
            curr = curr.left;
            }
            curr = s.peek();
            s.pop();
            v.add(curr.data);
            curr = curr.right;
    }
    return v;
    
}
}