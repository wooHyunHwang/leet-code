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
    private int i = 0;
    private int p = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length - 1;
        p = postorder.length - 1;

        return recursive(inorder, postorder, -3001);
    }

    private TreeNode recursive(int[] inorder, int[] postorder, int parentVal) {
        if (p < 0) return null;
        if (inorder[i] == parentVal) {
            --i;
            return null;
        }

        TreeNode node = new TreeNode(postorder[p--]);
        node.right = this.recursive(inorder, postorder, node.val);
        node.left = this.recursive(inorder, postorder, parentVal);
        return node;
    }
}