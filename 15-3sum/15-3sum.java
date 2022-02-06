class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, last = (int) -1e5 - 10;
        
        for(int i = 0; i < n; i++){
            if(nums[i] == last) 
                continue;
            
            last = nums[i];
            int sum = 0 - nums[i];
            int lo = i + 1, hi = n - 1;  
            int low = nums[0] - 1, high = nums[n - 1] + 1;
            
            while(lo < hi){
                int maybe = nums[lo] + nums[hi];
                
                if(maybe < sum || nums[lo] == low){
                    lo++;
                }else if(maybe > sum || nums[hi] == high){
                    hi--;
                }else {                    
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                    low = nums[lo];
                    high = nums[hi];
                }
            }
        }
        
        return triplets;
    }
}