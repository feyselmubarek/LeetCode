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
        
        return new int[]{-1, -1};
    }
}