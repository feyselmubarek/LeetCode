class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> res){
        if(index >= nums.length){
            return;
        }
        
        curr.add(nums[index]);
        res.add(new ArrayList<>(curr));
        
        helper(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);
        helper(nums, index + 1, curr, res);
    }
}