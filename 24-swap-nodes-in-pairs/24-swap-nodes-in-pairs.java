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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode node = head;
        
        while(node != null && node.next != null){
            node.val += node.next.val;
            node.next.val = node.val - node.next.val;
            node.val -= node.next.val;
            
            node = node.next.next;
        }
        
        return dummy.next;
    }
}