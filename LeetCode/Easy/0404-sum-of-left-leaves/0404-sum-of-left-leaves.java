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
    public int sumOfLeftLeaves(TreeNode root) {
        if (isLeaf(root)) return 0;
        return find(0, root);
    }

    private int find(int sum, TreeNode node) {
        
        // left
        if (node.left != null) {
            if(isLeaf(node.left)) {
                // System.out.println(node.left.val);
                sum += node.left.val;
            } else {
                sum = find(sum, node.left);
            }
        }

        // right
        if (node.right != null) {
            sum = find(sum, node.right);
        }

        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}