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
    public int maxLevelSum(TreeNode root) {

        long[] sumAry = new long[10_001];
        sumAry[0] = Integer.MIN_VALUE;

        int lastDepth = cycle(root, sumAry, 1);

        int maxIdx = 0;

        for(int i = 1; i <= lastDepth; ++i) {
            if(sumAry[maxIdx] < sumAry[i]) maxIdx = i;
        }

        return maxIdx;
    }

    private int cycle(TreeNode node, long[] sumAry, int depth) {
        if(node == null) return depth;

        sumAry[depth] += node.val;

        int diff = -1;
        if(node.left != null) diff = cycle(node.left, sumAry, depth + 1);
        if(node.right != null) diff = Math.max(diff, cycle(node.right, sumAry, depth + 1));

        return Math.max(depth, diff);
    }
}