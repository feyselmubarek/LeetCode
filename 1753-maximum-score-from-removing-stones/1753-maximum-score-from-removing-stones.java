class Solution {
    public int maximumScore(int a, int b, int c) {
        int max = (a + b + c) / 2;
        int pairSum = Math.min(a + b, Math.min(a + c, b + c));
        return Math.min(pairSum, max);
    }
}