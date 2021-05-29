class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int ct = 0, res = -1;
        
        //queue to store cells which have rotten oranges.
        Queue<ArrayList<Integer>> q = new LinkedList<>(); 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        //traversing over all the cells of the matrix.
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                //if grid value is more than 0, we increment the counter.
                if(grid[i][j]>0) 
                    ct++;
                //if grid value is 2, we push the cell indexes into queue.
                if(grid[i][j]==2)
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.add(temp);
                }
            }
        }
        
        while(!q.isEmpty())
        {
            //incrementing result counter.
            res++;
            int size = q.size();
            for(int k=0; k<size; k++)
            {
                //popping the front element of queue and storing cell indexes.
                ArrayList<Integer> cur=q.poll();
                ct--;
                
                //traversing the adjacent vertices.
                for(int i=0; i<4; i++)
                {
                    int x=cur.get(0)+dx[i], y=cur.get(1)+dy[i];
                    
                    //if cell indexes are within matrix bounds and grid value
                    //is not 1, we continue the loop else we store 2 in current
                    //cell and push the cell indexes in the queue.
                    if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]!=1)
                        continue;
                    grid[x][y]=2;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    q.add(temp);
                }
            }
        }
        //returning the minimum time.
        if(ct==0)
            return Math.max(0, res);
        return -1;
    }
}