class Solution {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                Arrays.sort(nums, i, nums.length);
                int swapIdx = findNextBig(nums, nums[i - 1], i);
                int temp = nums[swapIdx];
                nums[swapIdx] = nums[i - 1];
                nums[i - 1] = temp;
                return;
            }   
        }
        Arrays.sort(nums);
    }
    
    int findNextBig(int[] nums, int num, int idx){
        while(idx < nums.length){
            if(nums[idx] > num){
                return idx;
            }
            idx++;
        }
        return nums.length;
    }
}