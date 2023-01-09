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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            
            if(current.right != null){
                stack.push(current.right);
            }
            
            if(current.left != null){
                stack.push(current.left);
            }
        }
        
        return result;
    }
}