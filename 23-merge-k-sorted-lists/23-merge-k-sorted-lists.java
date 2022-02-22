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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            node.next = min;
            if(min.next != null){
                minHeap.add(min.next);
            }
            node = node.next;
            min.next = null;
        }
        
        return dummy.next;
    }
}