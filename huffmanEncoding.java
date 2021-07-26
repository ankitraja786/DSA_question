class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right;
    MinHeapNode(char data, int freq)
    {
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}

class Solution
{
    void getCodes(MinHeapNode root, String str, ArrayList<String> res)
    {
        if (root == null)
            return;
        if (root.data != '$')
        {
            res.add(str);
        }
        getCodes(root.left, str + "0", res);
        getCodes(root.right, str + "1", res);
    }



    ArrayList<String> huffmanCodes(String S, int[] f, int N)
    {

        MinHeapNode left, right, top;
        PriorityQueue<MinHeapNode> minHeap =
            new PriorityQueue<>( new Comparator<MinHeapNode>(){
            public int compare(MinHeapNode a, MinHeapNode b){
                if(a.freq >= b.freq){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });


        for (int i = 0; i < N; ++i)
            minHeap.add(new MinHeapNode(S.charAt(i), f[i]));

        while (minHeap.size() != 1)
        {
            left = minHeap.poll();

            right = minHeap.poll();

            top = new MinHeapNode('$', left.freq + right.freq);

            top.left = left;
            top.right = right;

            minHeap.add(top);
        }
        ArrayList<String> res = new ArrayList<String>();
        getCodes(minHeap.poll(), "", res);

        return res;
    }
};

