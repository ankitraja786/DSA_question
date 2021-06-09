#include<bits/stdc++.h>
using namespace std; 
#define int long long
#define N 100005

int n, odd, even, x, arr[N];

vector<int> gr[N];

void dfs(int ch, int par, int lvl)
{
	if(lvl%2==0)
		even += arr[ch];
	else
		odd += arr[ch];
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
		cin >> n;

		for(int i=1;i<=n;i++)
			gr[i].clear();

		for(int i=1;i<=n;i++)
			cin >> arr[i];

		for(int i=1;i<n;i++)
		{
			int u, v;
			cin >> u >> v;
			gr[u].push_back(v);
			gr[v].push_back(u);
		}

		odd = 0;
		even = 0;

		dfs(1, 0, 1);

		cout << abs(odd-even) << "\n";
	}

    return 0; 
}

