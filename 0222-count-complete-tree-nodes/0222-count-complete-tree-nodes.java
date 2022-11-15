/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int rightLevel = traverse(root, false), leftLevel = traverse(root, true);
        
        if(rightLevel == leftLevel){            
           return (int) Math.pow(2, leftLevel) - 1;
        }
        
        int left = (int) Math.pow(2, leftLevel - 1);
        int right = (int) (Math.pow(2, leftLevel)) - 1;
        
        while(left <= right){
            int mid = left + ((right - left) / 2);
            
            ArrayList<Integer> path = new ArrayList<>();
            int end = mid;
            
            while(end >= 1){
                path.add(end);
                end /= 2;
            }
            
            if(checkPath(root, path, path.size() - 1)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    public boolean checkPath(TreeNode node, ArrayList<Integer> path, int idx){
        if(idx == 0){
            return node != null;
        }
        return checkPath(path.get(--idx) % 2 == 0 ? node.left : node.right, path, idx);
    }
    
    public int traverse(TreeNode node, boolean isLeft){        
        return node == null ? 0 : traverse(isLeft ? node.left : node.right, isLeft) + 1;
    }
}