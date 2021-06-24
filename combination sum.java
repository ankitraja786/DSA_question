class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum)
    {
        Collections.sort(list);
		ArrayList<Integer> r = new ArrayList<>();
		ArrayList<Integer> C = new ArrayList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int i,j;
		
		//storing only distinct elements in list C.
    	for(i=0;i<list.size();i++){
    	    j=i+1;
    	    while(j<list.size()&&list.get(i) == list.get(j)){
    	        j++;
    	    }
    	    C.add(list.get(i));
    	    i=j-1;
    	}
		findNumbers(C, sum, res, r, 0);
		//returning the result.
		return res;
    }
    
    static void findNumbers(ArrayList<Integer> ar, int sum, 
            ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r, int i) 
    {
		//returning if conditions are out of bound. 
		if (sum < 0 || i >= ar.size())
			return;
 
		//pushing the combination in result if the sum becomes equal to 0.
		if (sum == 0) {
			res.add(new ArrayList<Integer>(r));
			return;
		}
		
	    //pushing to current for possible answer.
        r.add(ar.get(i));
        
        //calling function recursively for further inclusions.
        findNumbers(ar, sum-ar.get(i), res, r, i);
        
        //backtracking to remove already present number in combination
        //and provide space for further additions and possible answers.
        r.remove(r.size()-1); 
	                    
	    //calling function recursively to move to next index as all possible
    	//combination for current index have been done.
        findNumbers(ar, sum, res, r, i+1);
		
	}
}

