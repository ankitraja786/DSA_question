class Solution
{
    public static class HeapItem implements Comparable<HeapItem>
    {
        int[] array;                
        int index;        
      
        //declaring HeapItem.
        public HeapItem(int[] arr, int index) 
        {
           array = arr;
           this.index=index;
        }   
        @Override
        public int compareTo(HeapItem h)
        {
          if(array[index] > h.array[h.index])
              return 1;
          else if(array[index] < h.array[h.index])
              return -1;
          else
              return 0;
        }
        
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
      
        //implementing heap using priority queue.
        PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();             
        
        //adding arrays to the heap.
        for (int i = 0; i < arrays.length; i++) 
        {
            pq.add(new HeapItem(arrays[i], 0));
        }
        
        //using a list to store the resultant array after merging.
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        
        //using a loop while priority queue is not empty.
        while (!pq.isEmpty())
        {
            HeapItem current = pq.remove();
            //adding the element at current in list.
            result.add(current.array[current.index]);                       
            if (current.index < current.array.length-1) 
            {  
        	    current.index++;
        	    pq.add(current); 
            }
        }
        //returning the result.
        return result;
    } 
}

