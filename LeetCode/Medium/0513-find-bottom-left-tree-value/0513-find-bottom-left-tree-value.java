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
    private int maxDepth = -1;
    private int maxDepthLeft = 0;

    public int findBottomLeftValue(TreeNode node) {
        this.maxDepth = -1;
        this.maxDepthLeft = 0;
        this.recursive(node, 0);
        return this.maxDepthLeft;
    }

    private void recursive(TreeNode node, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
            maxDepthLeft = node.val;
        }

        if (node.left != null) this.recursive(node.left, depth+1);
        if (node.right != null) this.recursive(node.right, depth+1);
    }

    public int findBottomLeftValue2(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList<>();

            TreeNode first = queue.peek();
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();

                if (cur.left != null) newQueue.add(cur.left);
                if (cur.right != null) newQueue.add(cur.right);
            }

            queue = newQueue;

            if (queue.isEmpty()) return first.val;

        }

        return -1;
    }
}