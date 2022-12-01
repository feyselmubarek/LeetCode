class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length(), h = haystack.length();
        if (n == 0)
            return 0;
        if(n > h)
            return -1;
        int nHash = calcHash(needle, 0, n - 1);
        int hHash = -1;
        for(int i = 0; i < h-n+1; i++) {
            if(hHash == -1){
                hHash = calcHash(haystack, 0, n - 1);
            }else{
                hHash = hHash - Integer.valueOf(haystack.charAt(i-1)) + Integer.valueOf(haystack.charAt(i+n-1));
            }
            if(nHash == hHash && needle.equals(haystack.substring(i, i+n))){
                return i;
            }
        }
        return -1;
    }
    
    private int calcHash(String s, int start, int end){
        int hash = 0;
        for(int i = start; i<= end; i++){
            hash += Integer.valueOf(s.charAt(i));
        }
        return hash;
    }
}
