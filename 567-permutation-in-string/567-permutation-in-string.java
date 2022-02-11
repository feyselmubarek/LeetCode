class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] mapS1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            mapS1[s1.charAt(i) - 97]++;
        }
        
        int len = s1.length();
        int[] mapS2 = new int[26];
        for(int i = 0; i + len <= s2.length(); i++){
            if(i == 0){
                int j = 0;
                while(j < len){
                    mapS2[s2.charAt(j) - 97]++;
                    j++;
                }
            }else{
                int p = i - 1;
                int n = i + len - 1;
                mapS2[s2.charAt(p) - 97]--;
                mapS2[s2.charAt(n) - 97]++;
            }
            
            if(check(mapS1, mapS2)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean check(int[] a, int[] b){
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        
        return true;
    }
}