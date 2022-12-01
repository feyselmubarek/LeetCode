class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i <= s.length() - 10; i++){
            String maybe = s.substring(i, i + 10);
            if(set.contains(maybe)){
                ans.add(maybe);
            }
            set.add(maybe);
        }
        return new ArrayList<>(ans);
    }
    
}