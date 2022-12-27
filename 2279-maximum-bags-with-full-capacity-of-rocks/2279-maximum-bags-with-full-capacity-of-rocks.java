class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] bag = new int[n];
        
        for(int i = 0; i < n; i++){
            bag[i] += capacity[i] - rocks[i];
        }
        
        Arrays.sort(bag);
        int full = 0;
        
        for(int i = 0; i < n; i++){
            if(additionalRocks < bag[i]){
                break;
            }
            
            additionalRocks -= bag[i];
            full++;
        }
        
        return full;
    }
}