class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int LEN_1 = nums1.length, LEN_2 = nums2.length, TOT_LEN = LEN_1 + LEN_2;
        int low = 0, high = LEN_1;
        
        // We assume X to be small sized array and Y the large.
        // Variable naming taken this incodsideration
        while(low <= high){
            int partX = (high + low) / 2;
            int partY = ((TOT_LEN + 1) / 2 ) - partX;
            
            int xLeft = getMax(partX, nums1);
            int xRight = getMin(partX, nums1);
            
            int yLeft = getMax(partY, nums2);
            int yRight = getMin(partY, nums2);
            
            if(xLeft <= yRight && yLeft <= xRight){
                if(TOT_LEN % 2 == 0){
                    return (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2.0;
                }
                
                return Math.max(xLeft, yLeft);
            }else if(xLeft < yRight){
                low = partX + 1;
            }else{
                high = partX - 1;
            }
        }
        
        return -1;
    }
    
    private int getMax(int part, int[] nums){
        return part > 0 ? nums[part - 1] : (int) (-1 * (1e7));
    } 

    private int getMin(int part, int[] nums){
        return part < nums.length ? nums[part] : (int) 1e7;
    }
}