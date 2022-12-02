class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        
        int[] counts = new int[26];
        for(int idx = 0; idx < word1.length(); idx++){
            counts[word1.charAt(idx) - 'a']++;
        }
         
        int[] counts2 = new int[26];
        for(int idx = 0; idx < word2.length(); idx++){
            counts2[word2.charAt(idx) - 'a']++;
            if(counts[word2.charAt(idx) - 'a'] == 0){
                return false;
            }
        }
        
        Arrays.sort(counts);
        Arrays.sort(counts2);
        
        for(int i = 0; i < 26; i++){
            if(counts[i] != counts2[i]){
                return false;
            }
        }

        return true;
    }
}