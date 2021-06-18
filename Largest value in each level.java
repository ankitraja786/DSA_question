class Solution
{
    public void helper(ArrayList<Integer> res, Node root, int d)
    {
        if (root == null)
            return;
    
        // Expand list size
        if (d == res.size())
            res.add(root.data);
    
        else
    
            // to ensure largest value
            // on level is being
            res.set(d,Math.max(res.get(d), root.data));
    
        // Recursively traverse left and
        // right subtrees in order to find
        // out the largest value on each level
        helper(res, root.left, d + 1);
        helper(res, root.right, d + 1);
    }
    public ArrayList<Integer> largestValues(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res,root,0);
        return res;
    }
}