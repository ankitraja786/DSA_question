class Tree
{
    int countLeaves(Node node) 
    {
         // Your code 
         if(Node==NULL)
         return 0;
         if(Node->left=NULL && Node->right=NULL)
         return 1;
         else
         return getLeafCount(Node->left)+getLeafCount(Node->right);
    }
}
