class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
     Node head = new Node(-1,-1);
        Node tail = new Node(-1,-1);
        int cap;
        HashMap<Integer, Node> hm = new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.next=temp;
        newNode.prev=head;
        head.next=newNode;
        temp.prev=newNode;
    }
    public void deleteNode(Node delNode){
        Node delPrev=delNode.prev;
        Node delNext= delNode.next;
        delPrev.next=delNext;
        delNext.prev=delPrev;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node resNode=hm.get(key);
            int res = resNode.val;
            hm.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            hm.put(key,head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node existingNode = hm.get(key);
            hm.remove(key);
            deleteNode(existingNode);
        }
        if(hm.size()==cap){
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        hm.put(key,head.next);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */