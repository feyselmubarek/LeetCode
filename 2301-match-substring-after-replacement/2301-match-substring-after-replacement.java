class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {        
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for(char[] pair : mappings){
            HashSet<Character> changes = map.getOrDefault(pair[0], new HashSet<>());
            changes.add(pair[1]);
            map.put(pair[0], changes);
        }
        
        for(int i = sub.length(); i < s.length() + 1; i++){
            if(check(s, i - sub.length(), sub, map)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean check(String s, int i, String sub, HashMap<Character, HashSet<Character>> map){
        int n = sub.length();
        
        for(int idx = 0; idx < n; idx++){
            char src = sub.charAt(idx);
            char des = s.charAt(i + idx);
            
            if(src != des && !map.getOrDefault(src, new HashSet<>()).contains(des)){
                    return false;
            }
        }
        
        return true;
    }
}