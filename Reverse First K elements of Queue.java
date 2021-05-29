class GfG
{
    //Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        //using a stack and another queue to reverse first k elements.
        Stack<Integer> s=new Stack<>();           
        Queue<Integer> qq=new LinkedList<>();
        
        //we pop first k elements from queue and push it in the stack.
        while(k-->0)
        {                               
            int a=q.peek();
            q.poll();
            s.push(a);
        }
        //while stack is not empty, we push the elements into the new queue.
        while(!s.isEmpty())
        {                        
            int a=s.peek();
            s.pop();
            qq.add(a);
        }
        //then we add rest of the elements of original queue to the new queue.
        while(!q.isEmpty())
        {                     
            int a=q.peek();
            q.poll();
            qq.add(a);
        }
        //returning the new queue.
        return qq;                                   
    }   
}

