class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int trappedWater = 0;
        
        for(int i = height.length - 1; i >= 0;){
            if(stack.isEmpty() || height[i] < height[stack.peek()]){
                stack.push(i);
                i--;
            }else{
                int curr = height[stack.pop()];
                
                if(!stack.isEmpty()){
                    int width = stack.peek() - i - 1;
                    int _height = Math.min(height[i], height[stack.peek()]) - curr;
                    trappedWater += width * _height;       
                }
            }
        }
        
        return trappedWater;
    }
}