class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        
        for(int idx = 0; idx < s.length(); idx++){
            int len = stack.length();
            if(len == 0 || stack.charAt(len - 1) != s.charAt(idx)){
                stack.append(s.charAt(idx));
            }else{
                stack.deleteCharAt(len - 1);
            }
        }
    
        return stack.toString();
    }
}