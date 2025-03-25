class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;
    DLLNode(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    DLLNode head;
    DLLNode tail;
    int capacity;
    int size;
    HashMap<Integer,DLLNode> map;
    public LRUCache(int capacity) {
        head = new DLLNode(-1,-1);
        tail = new DLLNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<Integer,DLLNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            DLLNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            DLLNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
        else
        {
            DLLNode node = new DLLNode(key,value);
            map.put(key,node);
            addNode(node);
            size++;
            if(size>capacity)
            {
                delete(tail.prev);
                size--;
            }
        }
    }
    public void delete(DLLNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
    public void moveToHead(DLLNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addNode(node);
    }
    public void addNode(DLLNode node)
    {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */