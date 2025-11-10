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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list1;
        a=a-1;
        while(a!=0){
            temp1=temp1.next;
            a--;
        }
        while(b!=0){
            temp2=temp2.next;
            b--;
        } 
        ListNode linknode=temp2.next;
        temp1.next=list2;
        while(temp1.next!=null){
            temp1=temp1.next;
        }
        temp1.next=linknode;
        return list1;
    }
}