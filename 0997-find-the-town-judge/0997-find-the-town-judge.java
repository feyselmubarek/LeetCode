class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1], trusted = new int[n + 1];
        for(int[] t : trust){
            trusted[t[1]]++;
            trusts[t[0]]++;
        }
        
        for(int node = 1; node <= n; node++){
            if(trusted[node] == n - 1 && trusts[node] == 0){
                return node;
            }
        }
        
        return -1;
    }
}