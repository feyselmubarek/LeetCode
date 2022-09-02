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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        List<Double> averages = new ArrayList<>();
        
        nodes.add(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = nodes.removeFirst();
                sum += node.val;
                
                if(node.left != null){
                    nodes.addLast(node.left);
                }
                
                if(node.right != null){
                    nodes.addLast(node.right);
                }
            }
            averages.add(sum / size);
        }
        
        return averages;
    }
}