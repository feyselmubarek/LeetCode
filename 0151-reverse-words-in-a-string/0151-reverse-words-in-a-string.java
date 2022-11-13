class Solution {
    public String reverseWords(String s) {
        String trimmed = s.trim();
        String[] words = trimmed.split(" ");
        StringBuilder bl = new StringBuilder();
        
        for(int i = words.length - 1; i >= 0; i--){
            if(words[i].length() > 0){
                bl.append(words[i]);
                if(i != 0){
                    bl.append(" ");
                }
            }
        }
        
        return bl.toString();
    }
}