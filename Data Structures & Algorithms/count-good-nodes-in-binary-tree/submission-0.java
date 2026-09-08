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
    int count;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        count = 1;
        helper(root.left , root.val);
        helper(root.right , root.val);
        return count;
    }
    private void helper(TreeNode root , int maxvalue){
        if(root == null) return;
        if(root.val >= maxvalue){
            count++;
            maxvalue = root.val;
        }
        helper(root.left , maxvalue);
        helper(root.right , maxvalue);
    }
}
