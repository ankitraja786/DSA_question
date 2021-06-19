class Solution{
public:
	int isPlaindrome(string S)
	{

		for(int i = 0; i < S.size()/2; i++)
			if(S[i] != S[S.size() - i - 1])
				return 0;

		return 1;
	}

   
};

