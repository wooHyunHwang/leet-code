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

    private Integer lastValue = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        this.lastValue = null;
        this.min = Integer.MAX_VALUE;

        this.find(root);

        return this.min;
    }

    private void find(TreeNode node) {

        if(node.left != null) {
            find(node.left);
        } else if (lastValue == null) {
            // left 방향 첫번째 값 찾음
            // System.out.println("첫번째값 - " + node.val);
            lastValue = node.val;
            if(node.right != null) find(node.right);
            return;
        }

        if(lastValue != null) {
            // System.out.println("다음 - " + node.val);
            min = Math.min(min, Math.abs(node.val - lastValue));
            lastValue = node.val;
        }

        if(node.right != null) find(node.right);

    }
}
