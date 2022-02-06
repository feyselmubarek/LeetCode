class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> indices = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            indices.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int target = 0 - (nums[i] + nums[j]);
                int targetIdx = indices.getOrDefault(target, -1);
                if(targetIdx > j){
                    set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[targetIdx])));
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}