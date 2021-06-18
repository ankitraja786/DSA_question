void getTargetLeaf(Node* node, int* max_sum_ref, 
                   int curr_sum, Node** target_leaf_ref) 
{ 
    if (node == NULL) 
        return; 
  
    // Update current sum to hold sum of nodes on path 
    // from root to this node 
    curr_sum = curr_sum + node->data; 
  
    // If this is a leaf node and path to this node has 
    // maximum sum so far, then make this node target_leaf 
    if (node->left == NULL && node->right == NULL) { 
        if (curr_sum > *max_sum_ref) { 
            *max_sum_ref = curr_sum; 
            *target_leaf_ref = node; 
        } 
    } 
  
    // If this is not a leaf node, then recur down 
    // to find the target_leaf 
    getTargetLeaf(node->left, max_sum_ref, curr_sum, 
                  target_leaf_ref); 
    getTargetLeaf(node->right, max_sum_ref, curr_sum, 
                  target_leaf_ref); 
} 

int maxPathSum(Node* root)
{
    // base case 
    if (root == NULL) 
        return 0; 
  
    Node* target_leaf; 
    int max_sum = INT_MIN; 
  
    // find the target leaf and maximum sum 
    getTargetLeaf(root, &max_sum, 0, &target_leaf); 
  
    return max_sum; // return maximum sum 
}



// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    cin.ignore(256, '\n');
    while (t--)
    {
        string inp,c;
        getline(cin, inp);

        Node* root = buildTree(inp);
        
        cout<<maxPathSum(root)<<endl;
    }
    return 0;
}  