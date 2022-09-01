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
    public int goodNodes(TreeNode root) {
        return count(root, -1000000);
    }
    
    public int count(TreeNode node, int max){
        if(node == null){
            return 0;
        }
        
        int newMax = Math.max(node.val, max);
        int left = count(node.left, newMax);
        int right = count(node.right, newMax); 
        return  left + right + (node.val >= newMax ? 1 : 0);
    }
}