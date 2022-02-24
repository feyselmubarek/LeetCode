class Solution {
    public long countPairs(int[] nums, int k) {
        long pairs = 0l;
        HashMap<Long, Integer> gcds = new HashMap<>();
        for(int num : nums){
            long gcdFromNo1 = (long) findGCD(num, k);
            
            for(long gcdFromNo2 : gcds.keySet()){
                if(gcdFromNo1 * gcdFromNo2 % k == 0){
                    pairs += gcds.get(gcdFromNo2);
                }
            }
            gcds.put(gcdFromNo1, gcds.getOrDefault(gcdFromNo1, 0) + 1);
        }
        
        return pairs;
    }
    
    int findGCD(int a, int b){
        if(a == 0){
            return b;
        }        
        if(a > b){
            return findGCD(b, a);
        }
        return findGCD(b % a, a);
    }
}