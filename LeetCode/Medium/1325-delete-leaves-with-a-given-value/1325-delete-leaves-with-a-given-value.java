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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.recursive(root, target);

        if (root != null && root.left == null && root.right == null && root.val == target) {
            root = null;
        }

        return root;
    }

    private void recursive(TreeNode node, int target) {

        if (node == null) return;

        // 좌측 확인 잎
        if (node.left != null) {
            this.recursive(node.left, target);

            if (node.left.left == null && node.left.right == null && node.left.val == target) {
                node.left = null;
            }
        }

        // 우측 확인 잎
        if (node.right != null) {
            this.recursive(node.right, target);

            if (node.right.left == null && node.right.right == null && node.right.val == target) {
                node.right = null;
            }
        }
    }
}