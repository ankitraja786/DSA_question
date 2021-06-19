class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        return getRepeatNum(countAndSay(n-1),1);
        
    }
    String getRepeatNum(String s,int count){
    	int n=s.length();
    	if(n==1)
    		return String.valueOf(count)+s;
    	
    	if(s.charAt(0)==s.charAt(1)) {
    		return getRepeatNum(s.substring(1),count+1);
    	}
    	else {
    		return String.valueOf(count)+s.charAt(0)+getRepeatNum(s.substring(1),1);
    	}
    }

}
        
