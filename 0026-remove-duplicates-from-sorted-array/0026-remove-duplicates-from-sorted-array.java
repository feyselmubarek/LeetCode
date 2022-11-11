class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0, last = -1, len = nums.length;
        for(int idx = 0; idx < len; idx++){
            if(last == -1 || nums[last] != nums[idx]){
                nums[++last] = nums[idx];
                k++;
            }
        }
        
        return k;
    }
}