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
    public int findTilt(TreeNode root) {
        dfs(root);
        return summation(root);
    }
    
    public int summation(TreeNode node){
        return node == null ? 0 : summation(node.left) + summation(node.right) + node.val;
    }
    
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        int val = node.val;
        node.val = Math.abs(left - right);
        return left + right + val;        
    }
}