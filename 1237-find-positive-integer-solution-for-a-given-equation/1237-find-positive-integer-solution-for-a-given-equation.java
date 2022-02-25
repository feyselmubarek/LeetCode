/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> solutions = new ArrayList<>();
        for(int x = 1; x < 1000; x++){
            int left = 1, right = 1000;
            while(left <= right){
                int y = left + (right - left) / 2;
                int res = customfunction.f(x, y);
                
                if(res < z){
                    left = y + 1;
                }else if(res > z){
                    right = y - 1;
                }else{
                    solutions.add(new ArrayList<>(Arrays.asList(x, y)));
                    break;
                }
            }
        }
        
        return solutions;
    }
}