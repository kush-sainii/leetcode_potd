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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<lists.length; i++) {
            ListNode current = lists[i];  
            while(current != null) {       
                pq.add(current.val);
                current = current.next; 
            
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(!pq.isEmpty()) {
            ListNode nn = new ListNode(pq.poll());
            ptr.next = nn;
            ptr = ptr.next; 
        }
        ptr.next = null;
        return dummy.next;
    }
}