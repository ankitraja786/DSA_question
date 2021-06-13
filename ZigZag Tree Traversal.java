class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	     ArrayList<Integer> res = new ArrayList<Integer>(0);
	     
	    //if root is null, we return the list.
        if (root == null) 
        return res;
     
        //declaring two stacks to store the current and new level.
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
     
        //pushing the root in currentlevel stack.
        currentLevel.push(root);
        boolean leftToRight = true;
    
        while (!currentLevel.isEmpty()) 
        {
            //storing top element of currentlevel stack in temp and popping it.
            Node temp = currentLevel.pop();
            
            //if temp is not null, we store the data at temp in list.
            if(temp!=null)
            {
                res.add(temp.data);
                
                //if lefttoright is true then it stores nodes from left to right 
			    //else from right to left in nextlevel stack.
                if (leftToRight)
                {
                    if (temp.left!= null) {
                    nextLevel.push(temp.left);
                    }
                     
                    if (temp.right!= null) {
                    nextLevel.push(temp.right);
                    }
                }
                else 
                {
                    if (temp.right!= null) {
                    nextLevel.push(temp.right);
                    }
                     
                    if (temp.left!= null) {
                    nextLevel.push(temp.left);
                    }
                }
            }
         
            //if currentlevel stack is empty lefttoright is flipped to change 
		    //the order of storing the nodes and both stacks are swapped.
            if (currentLevel.isEmpty()) 
            {
                leftToRight = !leftToRight;
                Stack<Node> temp1 = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp1;
            }
        }
        //returning the list.
        return res; 
	}
}

