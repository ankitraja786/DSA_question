class Solution{
public:
    int x;
    struct trie{
        int cnt;
        trie* ch[26];
        trie(){
            cnt = 0;
            for(int i = 0;i < 26;i++)
            ch[i] = NULL;
        }
    };
    
    void build(string a[], trie *root){
        trie *temp;
        for(int i = 0;i < x;i++){
            temp = root;
            for(int j = 0;j < a[i].size();j++){
                if(temp->ch[a[i][j]-'a'] == NULL)
                    temp->ch[a[i][j]-'a'] = new trie();
                temp->ch[a[i][j]-'a']->cnt += 1;
                temp = temp->ch[a[i][j]-'a'];
            }
        }
    }
    
    int find(string s, trie *root){
        for(int i = 0;i < s.size();i++){
            if(root->ch[s[i]-'a'] == NULL)
            return 0;
            root = root->ch[s[i]-'a'];
        }
        return root->cnt;
    }
    
    vector<int> prefixCount(int N, int Q, string li[], string query[])
    {
        vector<int> res;
        x = N;
        trie *root = new trie();
        build(li, root);
        for(int i = 0;i < Q;i++)
            res.push_back(find(query[i], root));
        return res;
    }
};

