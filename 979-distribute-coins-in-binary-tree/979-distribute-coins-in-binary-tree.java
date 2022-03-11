/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int distributeCoins(TreeNode root) {
        int[] ans = {0};
        getMoves(root, ans);
        return ans[0];
    }
    
    public int getMoves(TreeNode node, int[] ans){
        if(node == null){
            return 0;
        }
        
        int left = getMoves(node.left, ans);
        int right = getMoves(node.right, ans);
        int change = left + right + node.val - 1;
        ans[0] += Math.abs(change);
        return change;
    }
}