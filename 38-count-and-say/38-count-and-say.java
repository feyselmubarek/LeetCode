class Solution {
    public String countAndSay(int n) {
        StringBuilder bl = new StringBuilder("1");
        
        for(int i = 1; i < n; i++){
            int last = -1, count = 0;
            StringBuilder hold = new StringBuilder();

            for(int j = 0; j < bl.length(); j++){
                if(bl.charAt(j) - '0' != last){
                    if(last != -1){
                        hold.append(count);
                        hold.append(last);
                    }
                    last = bl.charAt(j) - '0';
                    count = 0;
                }
                count++;
            }
            if(count > 0){
                hold.append(count);
                hold.append(last);
            }
            bl = hold;            
        }
        
        return bl.toString();
    }
}