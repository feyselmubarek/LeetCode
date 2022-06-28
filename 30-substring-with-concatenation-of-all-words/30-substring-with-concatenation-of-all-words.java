class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        HashMap<Integer, String> wordFromIdx = new HashMap<>();
        int len = words[0].length();
        for (int idx = 0; idx + len <= s.length(); idx++) {
            String maybe = s.substring(idx, idx + len);
            if (map.containsKey(maybe)) {
                wordFromIdx.put(idx, maybe);
            }
        }

        List<Integer> ans = new ArrayList<>();
        int windowLen = len * words.length;
        
        for (int idx = 0; idx + windowLen <= s.length(); idx++) {
            HashMap<String, Integer> _map = new HashMap<>();
            int itr = idx, usedWords = 0;

            while (itr + len <= s.length()) {
                String maybe = wordFromIdx.getOrDefault(itr, "");
                if (_map.getOrDefault(maybe, 0) >= map.getOrDefault(maybe, 0)) {
                    break;
                }

                _map.put(maybe, _map.getOrDefault(maybe, 0) + 1);
                itr += len;
                usedWords++;
            }

            if (usedWords == words.length) {
                ans.add(idx);
            }
        }

        return ans;
    }
}
