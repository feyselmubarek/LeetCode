class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {        
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length, MIN = (int) -1e9 + 7;
        Arrays.sort(nums);                
        
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
                
                int sum = target - (nums[i] + nums[j]);
                int l = j + 1, h = n - 1;
                int low = MIN, high = nums[h] + 1;
                
                while(l < h){
                    int maybe = nums[l] + nums[h];
                    if(maybe < sum || nums[l] == low){
                        l++;
                    }else if(maybe > sum || nums[h] == high){
                        h--;
                    }else{
                        quadruplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[h])));
                        low = nums[l];
                        high = nums[h];
                    }
                }
            }
        }
             
        return quadruplets;
    }
}