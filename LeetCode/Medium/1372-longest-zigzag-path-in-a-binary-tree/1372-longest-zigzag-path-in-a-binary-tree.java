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
    public int longestZigZag(TreeNode root) {

        // 좌
        int left = 0;
        if(root.left != null) left = find(root.left, 1, false);

        // 우
        int right = 0;
        if(root.right != null) right = find(root.right, 1, true);

        return Math.max(left, right);
    }
    /**
     * @param wayCount 지그재그 한 건수
     * @param direction 이전 방향 false: left, true: right
     */
    private int find(TreeNode node, int wayCount, boolean direction) {
        // System.out.println(wayCount);
        if(node.left == null && node.right == null) return wayCount;

        int left = 0;
        if(node.left != null) left = find(
            node.left,
            direction ? wayCount + 1 : 1,
            false
        );

        int right = 0;
        if(node.right != null) right = find(
            node.right,
            direction ? 1 : wayCount + 1,
            true
        );

        return Math.max(
            wayCount,
             Math.max(left, right)
        );
    }


























}