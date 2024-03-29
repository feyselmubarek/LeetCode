class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        N = 26
        a = ord('a')
        dp = [[0] * N]
        for i in range(1, len(s)+1):
            new = dp[i-1][:]
            j = ord(s[i-1]) - a
            new[j] += 1
            dp.append(new)
        ans = []
        for l, r, k in queries:
            L = dp[l]
            R = dp[r+1]
            ans.append(sum((R[i] - L[i]) & 1 for i in range(N)) // 2 <= k)
        return ans