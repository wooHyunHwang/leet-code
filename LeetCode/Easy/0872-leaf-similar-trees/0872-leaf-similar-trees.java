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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        Queue<Integer> qu = putDfs(root1, new LinkedList<>());
        boolean result = getDfs(root2, qu);

        if(qu.isEmpty() && result) return result;
        return false;
    }

    private Queue<Integer> putDfs(TreeNode node, Queue<Integer> qu) {

        if(node.left == null && node.right == null) {
            qu.add(node.val);
            return qu;
        }

        if(node.left != null) {
            qu = putDfs(node.left, qu);
        }

        if(node.right != null) {
            qu = putDfs(node.right, qu);
        }

        return qu;
    }

    private boolean getDfs(TreeNode node, Queue<Integer> qu) {

        if(node.left == null && node.right == null) {
            Integer no = qu.poll();
            if(no != null && no == node.val) return true;
            else return false;
        }

        if(node.left != null) {
            if(!getDfs(node.left, qu)) return false;
        }

        if(node.right != null) {
            if(!getDfs(node.right, qu)) return false;
        }
        
        return true;
    }





























}