class Solution {
    public boolean validPalindrome(String s) {
        return checkPal(s, 0, s.length() - 1, true);
    }
    
    boolean checkPal(String str, int s, int e, boolean canSkip){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)){
                return canSkip && (checkPal(str, s + 1, e, false) || checkPal(str, s, e - 1, false));
            }
            s++;
            e--;
        }
        return true;
    }
}