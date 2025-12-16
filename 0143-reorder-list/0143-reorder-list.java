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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode otherhead=slow.next;
        slow.next=null;
        ListNode prev=null;
        ListNode curr=otherhead;
        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        ListNode head1=head;
        ListNode head2=prev;
        while(head2!=null){
            ListNode t1=head1.next;
            ListNode t2=head2.next;
            head1.next=head2;
            head2.next=t1;
            head1=t1;
            head2=t2;
        }
    }
}