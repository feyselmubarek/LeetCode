class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int[] hrs = {1, 2, 4, 8};
        int[] mins = {1, 2, 4, 8, 16, 32};
        
        List<String> ans = new ArrayList<>();
        int hrsBit = 0;
        int minsBit = turnedOn;
        
        while(hrsBit <= turnedOn){
            List<Integer> possibleHrs = new ArrayList<>();
            dfs(hrs, 0, 0, hrsBit, possibleHrs, 11);
            List<Integer> possibleMins = new ArrayList<>();
            dfs(mins, 0, 0, minsBit, possibleMins, 59);
            
            for(Integer h : possibleHrs){
                for(Integer m : possibleMins){
                    ans.add(h + ":" + pad(m));
                }
            }
            
            hrsBit++;
            minsBit--;
        }
        
        return ans;
    }
    
    public void dfs(int[] bits, int i, int time, int count, List<Integer> ans, int limit){
        if(count == 0 && time <= limit){
            ans.add(time);
            return;
        }
        
        if(i >= bits.length || time > limit){
            return;
        }
        
        dfs(bits, i + 1, time + bits[i], count - 1, ans, limit);
        dfs(bits, i + 1, time, count, ans, limit);
    }
    
    public String pad(int num){
        return num > 9 ? num + "" : "0" + num;
    }
}



