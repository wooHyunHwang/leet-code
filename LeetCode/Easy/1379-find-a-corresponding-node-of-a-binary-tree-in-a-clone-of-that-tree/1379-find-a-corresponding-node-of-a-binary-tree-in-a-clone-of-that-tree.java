/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if (original == target) {
            return cloned;
        }

        if (original.left != null) {
            TreeNode left = this.getTargetCopy(original.left, cloned.left, target);
            if (left != null) return left;
        }

        if (original.right != null) {
            TreeNode right = this.getTargetCopy(original.right, cloned.right, target);
            if (right != null) return right;
        }

        return null;
    }
}