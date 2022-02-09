class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums){
            if(map.containsKey(num - k)){
                if(k != 0 || map.get(num - k) > 1){
                    pairs++;
                    map.remove(num - k);
                }
            }
        }
        return pairs;
    }
}