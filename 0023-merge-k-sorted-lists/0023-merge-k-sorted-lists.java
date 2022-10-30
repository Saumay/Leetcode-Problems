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
    
    /*
    Complexity analysis: O(N) = k.n
    k = number of linked lists
    n = number of nodes in each linked list
    */

    // 1) Approach 1: Using Sorting + Array
//     public ListNode mergeKLists(ListNode[] lists) {
//         List<Integer> arrList = new ArrayList<>();
//         for(ListNode node : lists) {
//             while(node != null) {
//                 arrList.add(node.val);
//                 node = node.next;
//             }
//         }
        
//         Collections.sort(arrList);
        
//         ListNode head = new ListNode(-1);
//         ListNode temp = head;
//         for(int num : arrList) {
//             ListNode newNode = new ListNode(num);
//             temp.next = newNode;
//             temp = temp.next;
//         }
//         return head.next;
//     }
    
    
    // 2) Approach 2.1: Comparing 1 by 1. Creating new linked list
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode head = new ListNode(-1);
//         ListNode temp = head;
        
//         while(true) {
//             int minIdx = -1;
//             for(int i=0 ; i<lists.length ; i++) {
//                 if(lists[i]!=null && (minIdx==-1 || lists[i].val<lists[minIdx].val))
//                     minIdx = i;
//             }
                
//             if(minIdx==-1)
//                 break;
                
//             temp.next = new ListNode(lists[minIdx].val);
//             lists[minIdx] = lists[minIdx].next;
//             temp = temp.next;
//         }
//         return head.next;
//     }
    
    
    // 2) Approach 2.2: Comparing 1 by 1. Constant space.
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode head = new ListNode(-1);
//         ListNode temp = head;
        
//         while(true) {
//             int minIdx = -1;
//             for(int i=0 ; i<lists.length ; i++) {
//                 if(lists[i]!=null && (minIdx==-1 || lists[i].val<lists[minIdx].val))
//                     minIdx = i;
//             }
                
//             if(minIdx==-1)
//                 break;
                
//             temp.next = lists[minIdx];
//             lists[minIdx] = lists[minIdx].next;
//             temp = temp.next;
//         }
//         return head.next;
//     }
    
    
    // 3) Approach 3: Using priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists) {
            add(pq, node);
        }
    
        while(!pq.isEmpty()) {            
            ListNode minNode = pq.poll();
            temp.next = minNode;
            temp = temp.next;
            add(pq, minNode.next);
        }
        return head.next;
    }
    
    private void add(PriorityQueue<ListNode> pq, ListNode node) {
        if(node!=null) 
            pq.add(node);
    }
    
    
    // 4) Approach 4: Using merge 2 linked lists
    // public ListNode mergeKLists(ListNode[] lists) {        
    //     ListNode head = null;
    //     for(int i=0 ; i<lists.length ; i++) {
    //         head = merge2Lists(head, lists[i]);
    //     }
    //     return head;
    // }
    
    
    // 5) Approach 5: Using divide and conquer to merge 2 lists
//     public ListNode mergeKLists(ListNode[] lists) {     
//         if(lists==null || lists.length==0)
//             return null;
        
//         ListNode head = null;
//         int window = lists.length-1;
        
//         while(window>=1) {
//             for(int i=0,j=window ; i<=j ; i++,j--) {
//                 lists[i] = merge2Lists(lists[i], lists[j]);
//             }
//             window /= 2;
//         }
//         return lists[0];
//     }
    
//     private ListNode merge2Lists(ListNode list1, ListNode list2) {
//         if(list1 == list2)
//             return list1;
        
//         ListNode head = new ListNode(-1);
//         ListNode temp = head;
        
//         while(list1!=null && list2!=null) {
//             if(list1.val < list2.val) {
//                 temp.next = list1;
//                 list1 = list1.next;
//             } else {
//                 temp.next = list2;
//                 list2 = list2.next;
//             }
//             temp = temp.next;
//         }
//         temp.next = list1==null ? list2 : list1;
//         return head.next;
//     }
}