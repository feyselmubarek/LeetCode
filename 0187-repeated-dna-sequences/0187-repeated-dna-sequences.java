class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() < 10){
            return ans;
        }
        
//         int MOD = (int) 1e5 + 7;
//         int hash = 0;
        
//         for(int i = 9; i >= 0; i--){
//             int val = (int) (((s.charAt(i) - '0') * Math.pow(26, i)) % MOD); 
//             hash += val; 
//         }
        
        // HashMap<Integer, HashSet<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String maybe = s.substring(i, i + 10);
            if(set.contains(maybe)){
                ans.add(maybe);
            }
            set.add(maybe);
        }
        return new ArrayList<>(new HashSet<>(ans));
    }
    
}