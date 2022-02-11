class Solution(object):
    def minCostClimbingStairs(self, cost):
        dp = [0] * len(cost)
        for idx in range(len(cost) - 1, -1, -1):
            maybe_1 = dp[idx + 1] if idx + 1 < len(cost) else 0
            maybe_2 = dp[idx + 2] if idx + 2 < len(cost) else 0
            dp[idx] = cost[idx] + min(maybe_1, maybe_2)
        return min(dp[0], dp[1])
             