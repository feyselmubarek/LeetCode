class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);        
        return ans;
    }
    
    public void helper(String s, int idx, List<String> curr, List<List<String>> ans){
        if(idx == s.length()){
            
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = idx + 1; i <= s.length(); i++){
            String maybe = s.substring(idx, i);
            
            if(isPalindrome(maybe)){
                curr.add(maybe);
                helper(s, i, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int s = 0, e = str.length() - 1;
        while(s < e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}