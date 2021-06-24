class Res {
    static String max = "";
}

class Solution
{
    //Function to set highest possible digits at given index.
    public static void findMaximumNumUtil(char ar[], int k, Res r)
    {
        if (k == 0) return;
        int n = ar.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                //if digit at position i is less than digit at position j, 
                //we swap them and check for maximum number so far.
                if (ar[j] > ar[i])
                {
                    char temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;

                    String st = new String(ar);
                    
                    //if current number is more than maximum so far
                    if (r.max.compareTo(st) < 0)
                    {
                        r.max = st;
                    }
                    //calling recursive function to set the next digit.
                    findMaximumNumUtil(ar, k - 1, r);

                    // backtracking
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        Res r = new Res();
        r.max = str;
        findMaximumNumUtil(str.toCharArray(), k, r);
        //returning the result.
        return r.max;
    }

}

