class Solution {
    public int countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k){
                idx = i;
                break;
            }
        }
        
        int l = 0, g = 0;
        for(int i = idx; i >= 0; i--){
            l += nums[i] < k ? 1 : 0;
            g += nums[i] > k ? 1 : 0;
            int diff = g - l;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        // System.out.println(map);
        int count = 0;
        l = g = 0;
        for(int i = idx; i < nums.length; i++){
            l += nums[i] < k ? 1 : 0;
            g += nums[i] > k ? 1 : 0;
            int diff = g - l;
            int comp = -1 * diff;
            
            count += map.getOrDefault(comp, 0);
            count += map.getOrDefault(comp + 1, 0);
        }
        
        return count;
    }
}