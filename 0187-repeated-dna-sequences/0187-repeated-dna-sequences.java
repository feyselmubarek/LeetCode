class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();
        int hash = 0;
        int MOD = (int) 1e9 + 7;
        HashSet<String> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 9; i >= 0; i--){
            hash += val(s.charAt(i)) * (int) Math.pow(4, 9 - i);
        }
        
        set.add(hash);
        // System.out.println(hash);
        for(int i = 10; i < s.length(); i++){
            int left = i - 10;
            hash -= val(s.charAt(left)) * (int) Math.pow(4, 9);
            hash *= 4;
            hash += val(s.charAt(i));
            
            if(set.contains(hash)){
                ans.add(s.substring(i - 9, i + 1));
            }
            set.add(hash);
            // System.out.println(hash);
        }
        
        return new ArrayList<>(ans);
    }
    
    public int val(char c){
        return c == 'A' ? 1 : c == 'C' ? 2 : c == 'G' ? 3 : 4;
    }
    
}