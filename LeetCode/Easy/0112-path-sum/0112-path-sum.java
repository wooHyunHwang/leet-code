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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        return find(root, targetSum, 0);

    }

    public boolean find(TreeNode root, int targetSum, int sum) {

        if (root == null) return targetSum == sum;

        sum += root.val;

        if (root.left == null && root.right == null) return targetSum == sum;

        if (root.left != null) {
            boolean left = find(root.left, targetSum, sum);

            if (left) return left;
        }

        if (root.right != null) {
            boolean right = find(root.right, targetSum, sum);

            if (right) return right;
        }

        return false;

    }


}