class Solution
{
    public:
    void flatten(Node *root)
    {
        if (root == NULL || root->left == NULL &&
	        root->right == NULL) {
		return;
	}

	// if root->left exists then we have
	// to make it root->right
	if (root->left != NULL) {

		// move left recursively
		flatten(root->left);

		// store the node root->right
		struct Node* tmpRight = root->right;
		root->right = root->left;
		root->left = NULL;

		// find the position to insert
		// the stored value
		struct Node* t = root->right;
		while (t->right != NULL) {
			t = t->right;
		}

		// insert the stored value
		t->right = tmpRight;
	}

	// now call the same function
	// for root->right
	flatten(root->right);
    }
};

