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
    int preindex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i] , i);
        }
        return helper(preorder , 0 , inorder.length-1);
    }
    private TreeNode helper(int[] preorder , int start , int end){
        if(start > end) return null;
        int val = preorder[preindex++];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        root.left = helper(preorder , start , index-1);
        root.right = helper(preorder , index+1 , end);
        return root;
    }
}
