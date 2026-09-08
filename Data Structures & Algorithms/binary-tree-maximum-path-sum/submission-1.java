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
    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum = root.val;
        helper(root);
        return maxsum;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int root_left = Math.max(helper(root.left) , 0);
        int root_right = Math.max(helper(root.right) , 0);
        maxsum = Math.max(maxsum , root.val + root_left + root_right);
        return root.val + Math.max(root_left , root_right);

    }
}
