class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(Arrays.asList(0)), paths, new boolean[graph.length]);
        return paths;
    }
    
    public void dfs(int[][] graph, int node, List<Integer> curr, List<List<Integer>> paths, boolean[] seen){
        if(node == graph.length - 1){
            paths.add(new ArrayList<>(curr));
            return;
        }
        
        for(int next : graph[node]){
            if(!seen[next]){
                seen[next] = true;
                curr.add(next);
                dfs(graph, next, curr, paths, seen);
                seen[next] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}