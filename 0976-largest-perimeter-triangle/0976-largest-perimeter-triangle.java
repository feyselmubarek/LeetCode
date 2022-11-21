class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0 ; i--) {
            if (checkValidity(A[i], A[i + 1], A[i + 2])) {
                return (A[i] + A[i + 1] + A[i + 2]);
            }
        }

        return 0;
    }

    private boolean checkValidity(int i, int j, int k) {
        if (i + j > k && i + k > j && k + j > i) {
            return true;
        }
        return false;
    }
}