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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 트리 노드 확인
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p == null && q == null) return true;
        // 값이 다름
        if (p.val != q.val) return false;

        // 값이 같음
        // left right 재귀
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}