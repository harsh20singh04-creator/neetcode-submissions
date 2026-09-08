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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    private void preorder(TreeNode root , StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left , sb);
        preorder(root.right , sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return buildTree(q);
    }
    private TreeNode buildTree(Queue<String> q){
        String value = q.poll();
        if(value.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}
