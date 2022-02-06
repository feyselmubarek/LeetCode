class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<Integer> first = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(first.contains(nums[i])) 
                continue;
            
            first.add(nums[i]);
            int sum = 0 - nums[i];
            int lo = i + 1, hi = nums.length - 1;
            
            HashSet<Integer> second = new HashSet<>();
            
            while(lo < hi){
                int maybe = nums[lo] + nums[hi];
                
                if(second.contains(nums[lo]) || maybe < sum){
                    lo++;
                }else if(second.contains(nums[hi]) || maybe > sum){
                    hi--;
                }else {
                    List<Integer> triple = new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    second.addAll(Arrays.asList(nums[lo], nums[hi]));
                    triplets.add(triple);
                }
            }
        }
        
        return triplets;
    }
}