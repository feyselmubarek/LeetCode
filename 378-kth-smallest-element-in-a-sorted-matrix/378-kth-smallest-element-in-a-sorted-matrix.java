class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length, left = matrix[0][0], right = matrix[N - 1][N - 1];
        int best = left;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = 0, max = matrix[0][0];
            
            for(int row = 0; row < N; row++){
                int posIdx = bs(matrix[row], mid);
                
                if(posIdx != -1){
                    count += posIdx + 1;
                    max = Math.max(max, matrix[row][posIdx]);
                }
            }
            
            
            if(count < k){
                left = mid + 1;
            }else{
                best = max;
                right = mid - 1;
            }
        }
        
        return best;
    }
    
    public int bs(int[] arr, int num){
        int l = 0, r = arr.length - 1, best = -1;
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(arr[m] <= num){
                best = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        
        return best;
    }
}