class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, last = -(int)1e5, occ = 1;
        
        for(int j = 0; j < nums.length; j++){
            if(last < nums[j] || occ < 2){
                if(last < nums[j]){
                    occ = 0;
                }
                nums[i] = nums[j];
                last = nums[j];
                i++;
                occ++;
            }
        }
        
        return i;
    }
}