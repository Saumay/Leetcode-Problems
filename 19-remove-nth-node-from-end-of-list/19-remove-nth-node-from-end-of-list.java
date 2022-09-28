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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head;
        for(int i=0 ; i<n ; i++)
            temp1 = temp1.next;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev2 = dummy;
        ListNode temp2 = head;
        
        while(temp1!=null) {
            prev2 = temp2;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        prev2.next = temp2.next;
        return dummy.next;
    }
}