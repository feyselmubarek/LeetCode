class Solution {
    public boolean detectCapitalUse(String word) {
        int last = -1, capitals = 0, n = word.length();
        for(int i = 0; i < n; i++){
            int idx = word.charAt(i) - 65;
            if(idx >= 0 && idx < 26){
                capitals++;
                last = i;
            }
        }
        
        return capitals == 0 || capitals == n || capitals + last == 1; 
    }
}