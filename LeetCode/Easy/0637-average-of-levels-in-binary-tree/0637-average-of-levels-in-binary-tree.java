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
    public List<Double> averageOfLevels(TreeNode root) {
        // key: depth
        // value: [0] - call count, [1] - sum
        Map<Integer, Long[]> data = new HashMap<>();

        int maxDepth = dfs(root, data, 1);

        List<Double> ans = new ArrayList<>();

        for(int i = 1; i < maxDepth; ++i) {
            if(data.containsKey(i)) {
                ans.add((double)data.get(i)[1] / data.get(i)[0]);
            }
            
        }

        return ans;
    }

    private int dfs(TreeNode node, Map<Integer, Long[]> data, int depth) {

        if(node == null) return depth;

        // 현재 depth 기록
        Long[] history = data.getOrDefault(depth, new Long[2]);
        if(history[0] != null) {
            history[0]++;
        } else {
            history[0] = 1L;
        }
        history[1] = history[1] == null ? node.val : history[1] + node.val;
        data.put(depth, history);

        // Depth 증가
        depth++;

        int leftDepth = Integer.MIN_VALUE;
        int rightDepth = Integer.MIN_VALUE;

        if(node.left != null) {
            leftDepth = dfs(node.left, data, depth);
        }
        if(node.right != null) {
            rightDepth = dfs(node.right, data, depth);
            
        }
        depth = Math.max(depth, leftDepth);
        depth = Math.max(depth, rightDepth);

        return depth;
    }
}