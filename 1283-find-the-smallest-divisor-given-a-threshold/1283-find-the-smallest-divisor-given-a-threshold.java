class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;        
        for(int num : nums){
            right = Math.max(right, num);
        }
        
        int best = 0;
        while(left <= right){
            int divisor = left + (right - left) / 2;
            int sum = 0;
            for(int num : nums){
                sum += divide(num, divisor);
            }
            
            if(sum <= threshold){
                best = divisor;
                right = divisor - 1;
            }else{
                left = divisor + 1;
            }
        }
        
        return best;
    }
    
    int divide(int num, int divisor){
        return (num / divisor) + Math.min(1, num % divisor);
    }
}