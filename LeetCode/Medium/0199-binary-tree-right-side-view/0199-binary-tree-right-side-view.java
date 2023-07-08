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
    Map<Integer, List<TreeNode>> levelMap = null;
    public List<Integer> rightSideView(TreeNode root) {

        levelMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        this.dfs(root, ans, 1);
        
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans, int level) {

        if(node == null) return;

        List<TreeNode> curReverse = levelMap.getOrDefault(level, new ArrayList<>());
        curReverse.add(node);
        levelMap.put(
            level,
            curReverse
        );

        if(curReverse.size() == 1) ans.add(curReverse.get(0).val);

        this.dfs(node.right, ans, level + 1);
        this.dfs(node.left, ans, level + 1);
    }
}