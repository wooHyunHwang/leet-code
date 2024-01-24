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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;

        this.dfs(root, new int[10]);

        return ans;
    }

    private void dfs(TreeNode node, int[] history) {

        history[node.val]++;
        if (node.left == null && node.right == null) {
            // history 체크
            // 홀
            int odd = 0;
            // 짝
            int even = 0;

            for (int i = 1; i < history.length; ++i) {
                // System.out.print(history[i] + " - ");
                if (history[i] == 0) continue;
                if (history[i] % 2 == 0) even++;
                else odd++;
            }

            // System.out.println("odd : " + odd + " / even : " + even);

            if (odd <= 1 && even >= 0) {
                // System.out.println("난가?");
                this.ans++;
            }

            // return;
        }

        if (node.left != null) this.dfs(node.left, history);
        if (node.right != null) this.dfs(node.right, history);
        history[node.val]--;

    }
}