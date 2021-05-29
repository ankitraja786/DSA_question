class Node {
    int key, value;
    Node next, pre;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = pre = null;
    }
}

class LRUCache 
{
    private static Map<Integer, Node> hsMap;
    private static int capacity, count;
    private static Node head, tail;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        hsMap = new HashMap<>();
        this.capacity = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        count = 0;
    }

    public static void addToHead(Node node) 
    {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    //Function to delete a node.
    public static void deleteNode(Node node)
    {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        //if element is present in map,
        if (hsMap.get(key) != null)
        {
            Node node = hsMap.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            
            //returning the value.
            return result;
        }
        //else we return -1.
        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value) 
    {
        if (hsMap.get(key) != null) 
        {
            Node node = hsMap.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } 
        else 
        {
            Node node = new Node(key, value);
            hsMap.put(key, node);
            if (count < capacity)
            {
                count++;
                addToHead(node);
            } 
            else 
            {
                hsMap.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

