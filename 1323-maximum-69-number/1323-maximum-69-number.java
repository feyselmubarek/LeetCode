class Solution {
    public int maximum69Number (int num) {
        int temp = num;
        int temp2 = 1, mult = 1;
        
        while(temp > 1){
            int digit = temp % 10;
            
            if(digit == 6){
                temp2 = 3 * mult;      
            }
            
            temp /= 10;
            mult *= 10;
        }
        
        if(temp2 == 1){
            return num;
        }
        
        return num + temp2;
    }
}