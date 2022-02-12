class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int endHash = endWord.hashCode();
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int itr = 0; itr < size; itr++){
                String curr = queue.poll();
                char[] str = curr.toCharArray();
                
                if(endHash == curr.hashCode() && curr.equals(endWord)){
                    return level;
                }

                for(int idx = 0; idx < str.length; idx++){
                    char c = str[idx];
                    for(char letter = 'a'; letter <= 'z'; letter++){
                        if(str[idx] != letter){
                            str[idx] = letter;
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
        
        return 0;
    }
}