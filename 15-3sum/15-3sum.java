class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int sum = 0 - nums[i];
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int maybe = nums[lo] + nums[hi];
                if(maybe == sum){
                    List<Integer> triple = new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    if(!set.contains(triple)){
                        set.add(triple);
                        triplets.add(triple);
                    }
                }
                if(maybe < sum){
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        
        return triplets;
    }
}