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
    private int[] history = null;
    public boolean isEvenOddTree(TreeNode node) {
        this.history = new int[100_001];
        return this.recursive(node, 0);
    }
    private boolean recursive(TreeNode node, int index) {
        if (node == null) return true;
        // 홀짝
        if (index % 2 == 0) {
            if (node.val % 2 != 1 || this.history[index] >= node.val) return false;
        } else {
            if (node.val % 2 != 0 || (this.history[index] != 0 && this.history[index] <= node.val)) return false;
        }

        this.history[index] = node.val;


        return this.recursive(node.left, index+1) && this.recursive(node.right, index+1);
    }

    public boolean isEvenOddTree2(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int index = 0;

        while(!queue.isEmpty()) {

            Queue<TreeNode> newQueue = new LinkedList<>();

            boolean odd = index % 2 == 0;
            int beforeVal = odd ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (odd) {
                    // 홀수 라인
                    if (cur.val % 2 != 1 || beforeVal >= cur.val) return false;
                    beforeVal = cur.val;
                } else {
                    // 짝수 라인
                    if (cur.val % 2 != 0 || beforeVal <= cur.val) return false;
                    beforeVal = cur.val;
                }
                if (cur.left != null) newQueue.add(cur.left);
                if (cur.right != null) newQueue.add(cur.right);
            }

            queue = newQueue;
            index++;
        }

        return true;
    }
}