class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            int occ = 1;
            if(map.containsKey(s.charAt(i))){
                occ += map.get(s.charAt(i));
            }
            map.put(s.charAt(i), occ);
        }
        
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(char c : map.keySet()){
            int occ = map.get(c);
            
            if(buckets[occ] == null){
                buckets[occ] = new ArrayList<>();
            }
            buckets[occ].add(c);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] != null){
                for(char c : buckets[i]){
                    for(int j = 0; j < map.get(c); j++){
                        builder.append(c);
                    }    
                }
            }
        }
        
        return builder.toString();
    }
}