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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        else {

            int currentDepth = 1;
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);
            
            while(!queue.isEmpty()) {

                Queue<TreeNode> newQueue = new LinkedList<>();
                currentDepth++;
                if (currentDepth > depth) break;

                while(!queue.isEmpty()) {
                    TreeNode node = queue.poll();

                    if (currentDepth == depth)  {
                        // left
                        TreeNode leftTemp = node.left;
                        node.left = new TreeNode(val);
                        node.left.left = leftTemp;
                        if (node.left.left != null) newQueue.add(node.left.left);
                        // right
                        TreeNode rightTemp = node.right;
                        node.right = new TreeNode(val);
                        node.right.right = rightTemp;
                        if (node.right.right != null) newQueue.add(node.right.right);
                    }
                    else {
                        if (node.left != null) newQueue.add(node.left);
                        if (node.right != null) newQueue.add(node.right);
                    }

                }

                queue = newQueue;
            }

            return root;

        }
    }
}