class Solution {
    int[] pref;
    public Solution(int[] w) {
        this.pref = new int[w.length + 1];
        for(int i = 1; i < w.length + 1; i++){
            pref[i] = pref[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int left = 0, right = pref.length - 1;
        int rand = new Random().nextInt(pref[pref.length - 1]) + 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(pref[mid] >= rand){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */