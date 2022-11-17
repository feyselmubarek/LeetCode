class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = calculate(ax1, ax2) * calculate(ay1, ay2);
        int area2 = calculate(bx1, bx2) * calculate(by1, by2);
        int area3 = 0;
        
        if(intersect(ax1, ax2, bx1, bx2) && intersect(ay1, ay2, by1, by2)){
            int w = calculate(Math.max(ax1, bx1), Math.min(ax2, bx2));
            int h = calculate(Math.max(ay1, by1), Math.min(ay2, by2));
            area3 = w * h;
        }
        
        return area1 + area2 - area3;
    }
    
    int calculate(int a, int b){
        return Math.abs(a - b);
    }
    
    boolean intersect(int a1, int a2, int a3, int a4){
        return (a1 <= a3 && a3 <= a2) || (a3 <= a1 && a1 <= a4);
    }
}