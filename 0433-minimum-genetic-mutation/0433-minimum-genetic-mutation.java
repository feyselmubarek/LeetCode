class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> words = new HashSet<>();
        
        for(String word : bank){
            words.add(word);
        }
        
        char[] letters = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
                
        int level = 0;
        int endHash = end.hashCode();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int itr = 0; itr < size; itr++){
                String curr = queue.poll();
                char[] str = curr.toCharArray();
                
                if(endHash == curr.hashCode() && curr.equals(end)){
                    return level;
                }

                for(int idx = 0; idx < str.length; idx++){
                    char c = str[idx];
                    for(char l : letters){
                        if(str[idx] != l){
                            str[idx] = l;
                            String newStr = new String(str);

                            if(words.contains(newStr)){
                                queue.add(newStr);
                                words.remove(newStr);
                            }

                            str[idx] = c;
                        }
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}