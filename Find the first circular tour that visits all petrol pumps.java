class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
	int tour(int petrol[], int distance[])
	{
		int n = petrol.length;
		
		//considering first petrol pump as a starting point.
		int start = 0;
		int end = 1;
		
		int cur_pet = petrol[start] - distance[start];
		
		//we run a loop while all petrol pumps are not visited and we have 
        //reached first petrol pump again with 0 or more petrol.
		while((end != start || cur_pet<0) && end <n )
		{
		    //if current amount of petrol in truck becomes less than 0,
            //then remove the starting petrol pump from tour.
			while(cur_pet<0 && start != end && start < n )
			{
			    //removing starting petrol pump and changing starting point.
				cur_pet -= petrol[start] - distance[start];
				start = (start+1)%n;
				
				//if 0 is being considered as start again, then there 
                //is no possible solution.
				if(start == 0)
					return -1;
			}
			//adding a petrol pump to current tour.
			cur_pet += petrol[end] - distance[end];
			end = (end+1)%n;
		}
		//returning starting point.
		return start;
	}
}