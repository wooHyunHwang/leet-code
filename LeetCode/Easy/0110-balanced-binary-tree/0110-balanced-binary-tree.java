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
    public boolean isBalanced(TreeNode root) {
        
        int ans = depthCnt(root);

        return ans != -1;

        // if(root == null) return true;
        // if(root.left == null && root.right == null) return true;

        // int left = depthCnt(root.left, 0);
        // int right = depthCnt(root.right, 0);

        // System.out.println("l : " + left);
        // System.out.println("r : " + right);

        // if (left != -1 && right != -1) {
        //     return Math.abs(left - right) <= 1;
        // } else {
        //     return false;
        // }

        
    }

    public int depthCnt(TreeNode root) {

        if(root == null) return 0;

        int lt = depthCnt(root.left);
        int rt = depthCnt(root.right);

        if (lt == -1 || rt == -1) return -1;

        if(Math.abs(lt - rt) >= 2) {
            return -1;
        }

        return Math.max(lt, rt) + 1;

    }
}