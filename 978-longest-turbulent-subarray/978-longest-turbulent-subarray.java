class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n == 1) return 1;
        
        int max = arr[0] != arr[1] ? 2 : 1, len = 2;
        for(int i = 2; i < n; i++){
            if(
                (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i]) || 
                (arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i]) ){
                len++;
            }else{
                len = arr[i - 1] != arr[i] ? 2 : 1;
            }
            max = Math.max(len, max);
        }
        
        return max;
    }
}