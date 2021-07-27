lass Solution{   
public:
    string smallestNumber(int S, int D){
        if(S==0)
    	{
    		if(D==1) 
    		    return "0";
    		else
    		    return "-1";
    	}
    	if(S>9*D)
    	{
    		return "-1";
    	}
    	int res[D];
    	S-=1;
    	string ans="";
    	for(int i=D-1;i>0;i--)
    	{
    		if(S>9)
    		{
    			res[i]=9;
    			S-=9;
    		}
    		else 
    		{
    			res[i]=S;
    			S=0;
    		}
    	}
    	res[0]=S+1;
    	for(int i=0;i<D;i++)
    		ans+=('0'+res[i]);
    	return ans;
        
    }
};

