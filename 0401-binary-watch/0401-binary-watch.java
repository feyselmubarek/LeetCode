class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int[] hrs = {1, 2, 4, 8};
        int[] mins = {1, 2, 4, 8, 16, 32};
        
        List<String> ans = new ArrayList<>();
        int hrsBit = 0;
        int minsBit = turnedOn;
        
        while(hrsBit <= turnedOn){
            List<String> possibleHrs = new ArrayList<>();
            dfsHrs(hrs, 0, 0, hrsBit, possibleHrs);
            
            List<String> possibleMins = new ArrayList<>();
            dfsMin(mins, 0, 0, minsBit, possibleMins);
            
            for(String h : possibleHrs){
                for(String m : possibleMins){
                    String hour = h.split(":")[0];
                    String minute = m.split(":")[1];
                    ans.add(hour + ":" + minute);
                }
            }
            
            hrsBit++;
            minsBit--;
        }
        
        return ans;
    }
    
    public void dfsMin(int[] bits, int i, int time, int count, List<String> ans){
        if(count == 0 && time <= 59){
            ans.add("00:"+ pad(time));
            return;
        }
        
        if(i >= bits.length || time > 59){
            return;
        }
        
        // included
        dfsMin(bits, i + 1, time + bits[i], count - 1, ans);
        // exclueded
        dfsMin(bits, i + 1, time, count, ans);
    }
    
    public void dfsHrs(int[] bits, int i, int time, int count, List<String> ans){
        if(count == 0 && time <= 11){
            ans.add(time + ":00");
            return;
        }
        
        if(i >= bits.length || time > 11){
            return;
        }
        
        // included
        dfsHrs(bits, i + 1, time + bits[i], count - 1, ans);
        // exclueded
        dfsHrs(bits, i + 1, time, count, ans);
    }
    
    public String pad(int num){
        return num > 9 ? num + "" : "0" + num;
    }
}

/*
totalBit = 5;
hrsBit = 5;
minBit = 0;

bits = [1,2,4,8,16,32]
bit = 3
                 
                 f(0),[](3)
               + /                         \ -
            f(1)[1](2)                       f(1)[](3)
            + /      -\                       + /
      f(2)[1,2](1)    f(2)[1](2)            f(2)[2]


*/



