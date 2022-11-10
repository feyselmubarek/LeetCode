class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int idx = 0; idx < s.length(); idx++){
            if(stack.empty() || stack.peek() != s.charAt(idx)){
                stack.push(s.charAt(idx));
            }else{
                stack.pop();
            }
        }
        
        StringBuilder bl = new StringBuilder();
        while(!stack.isEmpty()){
            bl.append(stack.pop());
        }
        
        return bl.reverse().toString();
    }
}