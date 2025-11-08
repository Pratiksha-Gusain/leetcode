/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode head=null;
        ListNode ptr=null;
        if(list1==null)
          return list2;
        if(list2==null)
           return list1;  
        while(list1!=null&&list2!=null)
        {
            if(head==null)
            {
                if(list1.val<=list2.val)
                {
                    ptr=head=list1;
                    list1=list1.next;
                }
                else
                {
                   ptr=head=list2;
                    list2=list2.next;
                }
            }
            else
            {
                if(list1.val<=list2.val)
                {
                    ptr.next=list1;
                    ptr=ptr.next;
                    list1=list1.next;
                }
                else
                {
                    ptr.next=list2;
                    ptr=ptr.next;
                    list2=list2.next;
                }

            }
        }
        if(list1!=null)
           ptr.next=list1;
        else 
          ptr.next=list2;

        return head;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode middle=findMiddle(head);
        ListNode left =head;
        ListNode right=middle.next;
        middle.next=null;
        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
}