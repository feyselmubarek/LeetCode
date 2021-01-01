/** 
 * link : https://leetcode.com/problems/two-sum/
 * 
 * Time complexity : O(N), where N is size of the given list of numbers
 * Space cimplexity : O(N), where N is size of the given list of numbers
*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int LEN = nums.length;
        HashMap<Integer, Integer> positions = new HashMap<>();
        
        for(int itr = 0; itr < LEN; itr++){
            if(positions.containsKey(target - nums[itr])){
                return new int[]{positions.get(target - nums[itr]), itr};
            }
            
            positions.put(nums[itr], itr);
        }
        
        return new int[]{};
    }
}