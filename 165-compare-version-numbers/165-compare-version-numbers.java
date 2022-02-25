class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revFromV1 = version1.split("[.]");
        String[] revFromV2 = version2.split("[.]");
        
        int i = 0, j = 0, n = revFromV1.length, m = revFromV2.length;
        while(i < n || j < m){
            int rev1 = i < n ? Integer.parseInt(revFromV1[i]): 0;
            int rev2 = j < m ? Integer.parseInt(revFromV2[j]) : 0;
            
            if(rev1 != rev2){
                return rev1 < rev2 ? -1 : 1;
            }
            
            i++;
            j++;
        }
        
        return 0;
    }
}