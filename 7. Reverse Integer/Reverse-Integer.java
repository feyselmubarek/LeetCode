/** 
 * link : https://leetcode.com/problems/reverse-integer/
 * 
 * Time complexity : O(N), where N is length of the number
 * Space complexity : O(1), 
*/

class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        long reversedNum = 0;
        
        while(num > 0){
            reversedNum = (reversedNum * 10) + (num % 10);
            num /= 10;
        }
        
        if(reversedNum > Integer.MAX_VALUE){
            return 0;
        }
        
        return (int) (x < 0 ? -1 * reversedNum : reversedNum);
    }
}