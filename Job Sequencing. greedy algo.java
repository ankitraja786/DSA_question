class jobComparator implements Comparator<Job>
{
    public int Compare(Job j1,Job j2)
    {
    if(j1.profit > j2.profit) return -1;
    if(j1.profit<j2.profit) return 1;
    return 0;
    }
}
class Solution
{
    
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new jobComparator());
        
        int res =0, count =0;
        // Your code here
        int [] result = new int [n];
        boolean []slot =new boolean[n];
        
        Arrays.fill(slot,false);
        
        for(int i=0;i<n; i++)
        {
            for(int j =Integer.min(n,arr[i].deadline)-1;j>0;j--)
            {
                if(slot[j]==false)
                {
                    result[j]=i;
                    slot[j] = true;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(slot[i]){
                count ++;
                res += arr[result[i]].profit;
            }
        }
        int[] ans = new int [2];
        ans[0] = count ;
        ans[1] =res;
        return  ans;
    }
}