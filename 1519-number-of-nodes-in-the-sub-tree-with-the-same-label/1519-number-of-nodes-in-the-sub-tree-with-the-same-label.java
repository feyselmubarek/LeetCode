class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for(int node = 0; node < n; node++){
            tree.put(node, new ArrayList<>());
        }
        
        for(int[] ed : edges){
            int a = ed[0], b = ed[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        int[] count = new int[n];
        
        dfs(tree, 0, new boolean[n], count, labels);
        return count;
    }
    
    public int[] dfs(HashMap<Integer, List<Integer>> tree, int node, boolean[] seen, int[] count, String labels){
        seen[node] = true;
        int[] res = new int[26];
        
        if(tree.get(node).size() == 1 && seen[tree.get(node).get(0)]){
            count[node] = 1;
            res[labels.charAt(node) - 'a']++;
            return res; 
        }
        
        for(int next : tree.get(node)){
            if(!seen[next]){
                int[] childRes = dfs(tree, next, seen, count, labels);
                for(int i = 0; i < 26; i++){
                    res[i] += childRes[i];
                }
            }
        }
        
        res[labels.charAt(node) - 'a'] += 1;
        
        count[node] = res[labels.charAt(node) - 'a']; 
        return res;
    }
}