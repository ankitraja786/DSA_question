class Tree
{
	public static int getSize(Node root)
	{
//add Code here.
      if(root==null)
      return 0;
      return getSize(root.left)+getSize(root.right)+1;

    }
}
