class Solution
{
	void printLeaves(Node node, ArrayList <Integer> res)
	{
		if(node != null)
		{
			printLeaves(node.left, res);
		
			if(node.left == null && node.right == null)
				res.add (node.data);
		
			printLeaves(node.right, res);
		}
	}
	
	void printBoundaryLeft(Node node, ArrayList <Integer> res)
	{
		if(node != null)
		{
			if(node.left != null)
			{
				res.add (node.data);
				printBoundaryLeft(node.left, res);
			}else if(node.right != null)
			{
				res.add (node.data);
				printBoundaryLeft(node.right, res);
			}
		}
		
	}
	void printBoundaryRight(Node node, ArrayList <Integer> res)
	{
		if(node != null)
		{
			if(node.right != null)
			{
				printBoundaryRight(node.right, res);
				res.add (node.data);
			}else if(node.left != null)
			{
				printBoundaryRight(node.left, res);
				res.add (node.data);
			}
		}
		
	}
	
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList <Integer> res = new ArrayList <Integer> (0);
		if(node != null)
			res.add (node.data);
		
		printBoundaryLeft(node.left, res);
			
		printLeaves(node.left, res);
		printLeaves(node.right, res);
			
		printBoundaryRight(node.right, res);
		return res;
	}
}

