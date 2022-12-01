class Solution {
    public boolean halvesAreAlike(String S) {
        String s = S.toLowerCase();
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                if(i < s.length() / 2){
                    left++;
                }else{
                    right++;
                }
            }
        }
        return left == right;
    }
    
    boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}