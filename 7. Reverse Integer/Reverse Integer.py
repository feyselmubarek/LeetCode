# link : https://leetcode.com/problems/reverse-integer/submissions/
# 
# Time complexity : O(N), where N is length of the number
# Space complexity : O(1), 

class Solution:
    def reverse(self, x: int) -> int:
        reversed_num = 0
        num = abs(x)
        INF = 2147483647
        
        while num > 0:
            reversed_num = (reversed_num * 10) + (num % 10)
            num = num // 10
            
        
        if reversed_num > INF:
            return 0
        
        return -1 * reversed_num if x < 0 else reversed_num