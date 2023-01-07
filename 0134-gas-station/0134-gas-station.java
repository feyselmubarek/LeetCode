class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prefixSum = 0, n = gas.length, i = 0;
        int sum = 0, len = 0, ans = -1, diff = 0;
        
        while(i < n){
            diff = gas[i] - cost[i]; 
            prefixSum += diff;
            sum += diff;
            
            if(sum < 0){
                sum = 0;
                len = 0;
            }else{
                ans = i - len;
                len++;
            }
            i++;
        }
        
        return prefixSum >= 0 ? ans : -1;
    }
}