class Solution {
    public int[] countBits(int n) {
        int pow = 1, num = 1;
        int[] dp = new int[n + 1];
        
        while(num <= n){
            if(num == pow){
                dp[num] = 1;
                pow *= 2;
            }else{
                dp[num] = dp[pow / 2] + dp[num - (pow / 2)];
            }
            num++;
        }
        
        return dp;
    }
}