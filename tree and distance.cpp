#include<bits/stdc++.h>
using namespace std; 
#define int long long
#define N 100005

int n, ans, x;

vector<int> gr[N];

void dfs(int ch, int par, int lvl)
{
	ans = max(ans, lvl);
	for(auto i:gr[ch])
		if(i!=par)
			dfs(i, ch, lvl+1);
}

// Driver code to test above functions
int32_t main()
{
    
     
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
	cout.tie(NULL);

	

	int t;
	cin >> t;
	while(t--)
	{
		cin >> n >> x;

		for(int i=1;i<=n;i++)
			gr[i].clear();

		for(int i=1;i<n;i++)
		{
			int u, v;
			cin >> u >> v;
			gr[u].push_back(v);
			gr[v].push_back(u);
		}

		ans = 0;

		dfs(x, 0, 0);

		cout << ans << "\n";
	}

    return 0; 
}

