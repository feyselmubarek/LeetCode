class Solution {
    public boolean canJump(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        seen[0] = true;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == nums.length - 1){
                    return true;
            }
            
            int len = nums[curr];
            
            for(int idx = curr + 1; idx < nums.length && idx - curr <= len; idx++){
                if(seen[idx]){
                    continue;
                }
                
                queue.add(idx);
                seen[idx] = true;
            }
        }
        
        return false;
    }
}