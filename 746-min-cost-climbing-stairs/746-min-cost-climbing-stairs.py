class Solution(object):
    def minCostClimbingStairs(self, cost):
        memo = [-1] * len(cost)
        self.dfs(cost, 0, memo)
        return min(memo[0], memo[1])
        
    def dfs(self, cost, idx, memo):
        if idx >= len(cost):
            return 0
    
        if memo[idx] != -1:
            return memo[idx]
        
        memo[idx] = cost[idx] + min(self.dfs(cost, idx + 1, memo), self.dfs(cost, idx + 2, memo))
        return memo[idx]
        
        
        