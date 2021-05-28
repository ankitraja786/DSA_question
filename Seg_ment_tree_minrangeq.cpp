#include "stdio.h"
 
int tree[1000001], a[1000001];
 
int min(int a, int b) { return a < b ? a : b; }
 
void build(int node, int left, int right)
{
	if (left == right) tree[node] = a[left];					// leaf node
	else
	{
		build(2*node, left, (left+right)/2);					// left subtree
		build(2*node + 1, (left+right)/2 + 1, right);			// right subtree
		tree[node] = min(tree[2*node], tree[2*node + 1]);		// current node
	}
}
 
int query(int node, int curr_l, int curr_r, int query_l, int query_r)
{
	if (curr_l > query_r || curr_r < query_l)					// out of range
		return 1e9;
	if (curr_l >= query_l && curr_r <= query_r)					// in range
		return tree[node];
	else														// min of left and right subtree
		return min( query(2*node, curr_l, (curr_l + curr_r) / 2, query_l, query_r),
					query(2*node + 1, (curr_l + curr_r) / 2 + 1, curr_r, query_l, query_r));
}
 
void update(int node, int left, int right, int index, int value)
{
	if (left == right) tree[node] = a[index] = value;			// leaf node
	else
	{
		if (left <= index && index <= (left+right)/2)			// left subtree
			update(2*node, left, (left+right)/2, index, value);
		else													// right subtree
			update(2*node + 1, (left+right)/2 + 1, right, index, value);
		tree[node] = min(tree[2*node], tree[2*node + 1]);		// current node
	}
}
 
int main()
{
	int n, i, q;
	scanf("%d%d", &n, &q);
	for (i=1; i<=n; i++) scanf("%d", &a[i]);
	build(1, 1, n);
	while (q--)
	{
		char c;
		int q1, q2;
		scanf("\n%c%d%d", &c, &q1, &q2);
		if (c == 'u') update(1, 1, n, q1, q2);
		else printf("%d\n", query(1, 1, n, q1, q2));
	}
}