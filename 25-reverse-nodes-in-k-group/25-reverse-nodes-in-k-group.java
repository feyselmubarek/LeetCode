/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), node = head, prev_head = dummy;
        
        while(node != null){
            ListNode itr = node;
            int size = 0;
            
            while(itr != null && size < k){
                itr = itr.next;
                size++;
            }
            
            if(size == k){
                ListNode new_head = reverse(node, k);  
                prev_head.next = new_head;
                node.next = itr;
                prev_head = node;
            }
            node = itr;
        }
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, int size){
        ListNode prev = start, curr = prev.next;
        int count = 1;
        
        while(curr != null && count < size){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        return prev;
    }
}