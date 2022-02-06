class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {        
        int n = nums.length, MIN = (int) -1e9 + 7;
        Arrays.sort(nums);        
        List<List<Integer>> quadruplets = new ArrayList<>();
        HashMap<Integer, Integer> indices = new HashMap<>();
        
        for(int i = 0; i < n; i++) 
            indices.put(nums[i], i);
        
        int first = MIN;
        for(int i = 0; i < n; i++){
            if(nums[i] == first)
                continue;
            first = nums[i];
            int second = MIN;
                
            for(int j = i + 1; j < n; j++){
                if(second == nums[j])
                    continue;
                second = nums[j];
                int third = MIN;
                
                for(int k = j + 1; k < n; k++){
                    if(nums[k] == third)
                        continue;
                    third = nums[k];
                    
                    int find = target - (nums[i] + nums[j] + nums[k]);
                    int index = indices.getOrDefault(find, -1);
                    if(index > k){
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[index]));
                        quadruplets.add(quad);
                    }
                }
            }
        }
        
             
        return quadruplets;
    }
}