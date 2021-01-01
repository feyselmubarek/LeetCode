# link : https://leetcode.com/problems/add-two-numbers/submissions/
# 
# Time complexity : O(N + M), where N and M are size of the gven linked lists
# Space cimplexity : O(N), where N is size of linkedList (the returned value)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        top, bottom, head, carry = l1, l2, ListNode(-1), 0
        curr = head
        
        while (top != None or bottom != None):
            summation = top.val if top else 0
            summation += bottom.val if bottom else 0
            summation += carry
            
            digit = summation % 10
            curr.next = ListNode(digit)
            curr = curr.next
            
            carry = summation // 10
            if top : top = top.next
            if bottom : bottom = bottom.next
        
        if carry: 
            curr.next = ListNode(carry)
        
        return head.next