class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
            
        for(int i = 0; i < candidates.length; i++){
            if(target - candidates[i] >= 0){
                dfs(candidates, target - candidates[i], i, new ArrayList<Integer>(Arrays.asList(candidates[i])), res);
            }
        }
        
        return res;
    }
    
    public boolean dfs(int[] candi, int target, int index, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return true;
        }
        
        for(int i = index; i < candi.length; i++){
            if(target - candi[i] < 0){
                return false;
            }
            
            curr.add(candi[i]);
            if(!dfs(candi, target - candi[i], i, curr, res)){
                curr.remove(curr.size() - 1);
            }
        }
        
        return false;
    }
}