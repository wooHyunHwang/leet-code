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
    public boolean checkTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {

            Queue<TreeNode> next = new LinkedList<>();

            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null && node.right != null) {
                    if (node.val != node.left.val + node.right.val) return false;
                }
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }

            queue = next;

        }

        return true;
    }
}