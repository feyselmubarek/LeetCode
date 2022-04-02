class Solution {
    public int maximumScore(int a, int b, int c) {
        return Math.min(Math.min(a + b, Math.min(a + c, b + c)), (a + b + c) / 2);
    }
}