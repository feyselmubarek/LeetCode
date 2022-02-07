class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++){
            arr[i] = new int[]{nums[i], nums[i]};
        }
        
        boolean sorted = false;
        ArrayList<Pair<Integer, Integer>>[] count = new ArrayList[10];
        while(!sorted){
            sorted = true;
            for(int i = 0; i < 10; i++){
                count[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < n; i++){
                int digit = arr[i][0] % 10;
                count[digit].add(new Pair<>(arr[i][0]/10, arr[i][1]));
                if(arr[i][0]/10 != 0){
                    sorted = false;
                }
            }
            
            int idx = 0;
            for(int i = 0; i < 10; i++){
                for(Pair<Integer, Integer> p : count[i]){
                    arr[idx] = new int[]{p.getKey(), p.getValue()};
                    idx++;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n - 1; i++){
            max = Math.max(max, arr[i + 1][1] - arr[i][1]);
        }
        
        return max;
    }
}