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

    Integer min;

    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        min = null;

        find(root, 0);

        return min;
        
    }

    public void find(TreeNode root, int newPath) {

        newPath++;

        if(min != null && newPath > min) {
            return;
        }
        
        if (root.left == null && root.right == null) {

            if (min == null) {
                min = newPath;
            } else if (min > newPath) {
                min = newPath;
            }
            return;

        } else {

            if (root.left != null) {
                int left = newPath;
                find(root.left, left);
            }

            if (root.right != null) {
                int right = newPath;
                find(root.right, right);
            }
            


            

        }
    }
























}