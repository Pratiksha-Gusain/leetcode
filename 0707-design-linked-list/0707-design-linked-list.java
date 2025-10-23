class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val =val;
            this.next=null;
        }
    }
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    
    public int get(int index) {
        if(index<0||index>=size) return -1;
        Node curr=head;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }

        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(size==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode =new Node(val);
        if(size==0){
            head=newNode;
            tail=newNode;
        }
        else{
           tail.next=newNode;
           tail=newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0||index>size) return;
        if(index==0){
            addAtHead(val);
            return;
        } 
        if(index==size){
            addAtTail(val);
            return;
        }
        Node curr=head;
        for(int i=0;i<index-1;i++) curr=curr.next;
        Node newNode=new Node(val);
        newNode.next=curr.next;
        curr.next=newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        if(index==0){
            head=head.next;
            if(size==1){
                tail=null;
            }
            size--;
            return;
        } 
        Node curr=head;
        for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        Node toDelete=curr.next;
        curr.next=toDelete.next;
        if(index==size-1){
            tail=curr;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */