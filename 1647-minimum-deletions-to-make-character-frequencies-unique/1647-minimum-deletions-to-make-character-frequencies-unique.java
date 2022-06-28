class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int count : map){
            if(count > 0){
                freq.put(count, freq.getOrDefault(count, 0) + 1);
            }
        }
        
        int deletions = 0;
        HashSet<Integer> newFreq = new HashSet<>();
        
        for(int occurance : freq.keySet()){
            int repeatition = freq.get(occurance);
            
            while(repeatition > 1){
                int newOcc = occurance;
                
                while(newOcc > 0 && (freq.containsKey(newOcc) || newFreq.contains(newOcc))){
                    deletions++;
                    newOcc--;
                }
                
                if(newOcc > 0){
                    newFreq.add(newOcc);
                }
                
                repeatition--;
            }
        }
        
        return deletions;
    }
}