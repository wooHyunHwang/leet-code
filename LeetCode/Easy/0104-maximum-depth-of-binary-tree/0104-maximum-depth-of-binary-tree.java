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

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;

        return find(maxDepth, root);
    }

    public int find(int maxDepth, TreeNode root) {
        
        if (root == null) return maxDepth;

        maxDepth++;

        int temp1 = maxDepth;
        int temp2 = maxDepth;

        temp1 = find(temp1, root.left);

        if (temp1 > maxDepth) maxDepth = temp1;


        temp2 = find(temp2, root.right);

        if (temp2 > maxDepth) maxDepth = temp2;




        return maxDepth;
    }
}