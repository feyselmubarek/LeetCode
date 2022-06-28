class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>();
        for(String s : supplies) sup.add(s);
        
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, Integer> dep = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        for(int idx = 0; idx < recipes.length; idx++){
            boolean canAdd = true;
            for(String ing : ingredients.get(idx)){
                if(!sup.contains(ing)){
                    canAdd = false;
                    List<String> neg = graph.getOrDefault(ing, new ArrayList<>());
                    neg.add(recipes[idx]);
                    
                    graph.put(ing, neg);
                    dep.put(recipes[idx], dep.getOrDefault(recipes[idx], 0) + 1);
                }               
            }
            
            if(canAdd){
                queue.add(recipes[idx]);
            }
        }
        
        
        while(!queue.isEmpty()){
            String r = queue.poll();
            ans.add(r);
            
            for(String neg : graph.getOrDefault(r, new ArrayList<>())){
                int count = dep.get(neg);
                
                if(count == 1){
                    queue.add(neg);
                }else{
                    dep.put(neg, count - 1);
                }
            }
        }
        
        
        return ans;
    }
}