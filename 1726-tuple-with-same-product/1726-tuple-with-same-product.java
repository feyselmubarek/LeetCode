class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> prods = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int prod = nums[i] * nums[j];
                int occ = prods.getOrDefault(prod, 0);
                count += occ * 8;
                prods.put(prod, occ + 1);
            }
            
        }
        
        // System.out.println(prods);
        
        return count;
    }
}