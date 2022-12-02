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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int count : counts){
            if(count != 0){
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }        
        
        for(int count : counts2){
            if(count != 0){
                if(!map.containsKey(count)){
                    return false;
                }
                
                int freq = map.get(count);
                if(freq == 1){
                    map.remove(count);
                }else{
                    map.put(count, freq - 1);
                }
            }
        }

        
        return map.isEmpty();
    }
}