class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length, pow = 1, max = 0;
        for(int num : nums)
            max = Math.max(max, num);
        
        
        while(max / pow > 0){
            int[] aux = new int[n];
            int[] count = new int[10];
            for(int i = 0; i < n; i++){
                int digit = (nums[i] / pow) % 10;
                count[digit]++;
            }
            
            for(int i = 1; i < 10; i++){
                count[i] += count[i - 1];
            }
            
            
            for(int i = n - 1; i >= 0; i--){
                int digit = (nums[i] / pow) % 10;
                int idx = count[digit] = count[digit] - 1;
                aux[idx] = nums[i];
            }
            
            nums = aux;
            pow *= 10;
        }
        
        int maxDiff = 0;
        for(int i = 0; i < n - 1; i++)
            maxDiff = Math.max(maxDiff, nums[i + 1] - nums[i]);
        
        return maxDiff;
    }
}