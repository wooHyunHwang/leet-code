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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> qwe = new ArrayList<>();
        qwe = zzzz(qwe, root);
        return qwe;
    }

    public List<Integer> zzzz(List<Integer> qwe, TreeNode node) {
        
        if(node == null) return qwe;

        qwe.add(node.val);

        if (node.left != null) qwe = zzzz(qwe, node.left);

        if (node.right != null) qwe = zzzz(qwe, node.right);

        return qwe;
    }
}