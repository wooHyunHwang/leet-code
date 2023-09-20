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
class BSTIterator {
    private Queue<Integer> queue = new LinkedList<>();;

    public BSTIterator(TreeNode root) {
        this.iteratoring(root);
    }

    private void iteratoring(TreeNode node) {

        if (node == null) return;

        if (node.left != null) this.iteratoring(node.left);
        queue.offer(node.val);
        if (node.right != null) this.iteratoring(node.right);
    }
    
    public int next() {
        if (this.hasNext()) return queue.poll();
        else return 0;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */