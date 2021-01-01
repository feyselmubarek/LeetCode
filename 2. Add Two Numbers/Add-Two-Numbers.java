/** 
 * link : https://leetcode.com/problems/add-two-numbers/
 * 
 * Time complexity : O(N + M), where N and M are size of the gven linked lists
 * Space cimplexity : O(N), where N is size of linkedList (the returned value)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = l1, bottom = l2, head = new ListNode(-1), curr = head;
        int carry = 0, sum = 0;
        
        while(top != null || bottom != null){
            sum = top == null ? 0 : top.val;
            sum += (bottom == null ? 0 : bottom.val) + carry;            
            int digit = sum % 10;

            curr.next = new ListNode(digit);
            curr = curr.next;
            
            carry = sum / 10;
            top = top != null ? top.next : top;
            bottom = bottom != null ? bottom.next : bottom;
        }
        
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        
        return head.next;
    }
}