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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }
    
    public boolean dfs(TreeNode node, int targetSum, int currentSum){
        currentSum += node.val;
        if(node.left == null && node.right == null){
            return targetSum == currentSum;
        }
        
        if(node.left != null && dfs(node.left, targetSum, currentSum)){
            return true;
        }
        
        return node.right != null && dfs(node.right, targetSum, currentSum);
    }
}