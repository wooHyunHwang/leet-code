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
    private List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        this.ans = new ArrayList<>();
        boolean[] delete = new boolean[1001];

        // default
        for (int d : to_delete) delete[d] = true;
        

        // process
        if (delete[root.val]) {
            if (root.left != null && !delete[root.left.val]) this.ans.add(root.left);
            if (root.right != null && !delete[root.right.val]) this.ans.add(root.right);
        }
        else {
            this.ans.add(root);
        }
        this.divideNodeByDFS(root, delete);

        return this.ans;
    }

    private void divideNodeByDFS(TreeNode node, boolean[] delete) {
        if (node.left != null) {
            this.divideNodeByDFS(node.left, delete);
            if (delete[node.left.val]) {
                if (node.left.left != null) this.ans.add(node.left.left);
                if (node.left.right != null) this.ans.add(node.left.right);
                node.left = null;
            }
        }

        if (node.right != null) {
            this.divideNodeByDFS(node.right, delete);
            if (delete[node.right.val]) {
                if (node.right.left != null) this.ans.add(node.right.left);
                if (node.right.right != null) this.ans.add(node.right.right);
                node.right = null;
            }
        }
    }
}