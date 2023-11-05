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

    List<List<Integer>> ans = null;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        ans = new ArrayList<>();

        this.dfs(root, targetSum, new LinkedList<>(), 0);

        return ans;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> list, int sum) {

        if (node == null) return;

        sum += node.val;

        if (sum == targetSum && node.left == null && node.right == null) {

            List<Integer> copy = new ArrayList<>(list);
            copy.add(node.val);

            this.ans.add(copy);
        }

        list.add(node.val);
        
        if (node.left != null) this.dfs(node.left, targetSum, list, sum);
        if (node.right != null) this.dfs(node.right, targetSum, list, sum);

        list.remove(list.size() - 1);

        
    }
}