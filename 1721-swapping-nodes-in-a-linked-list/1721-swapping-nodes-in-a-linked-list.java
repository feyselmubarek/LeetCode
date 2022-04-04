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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode kthFromStart = head, kthFromLast = head, node = head;
        int gap = 0;
        
        while(node != null){
            gap++;
            if(gap <= k){
                kthFromStart = node;
            }else{
                kthFromLast = kthFromLast.next;
            }
            node = node.next;
        }
        
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromLast.val;
        kthFromLast.val = temp;
        
        return dummy.next;
    }
}