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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        this.dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode node, List<List<Integer>> ans, int index) {
        if (node == null) return;

        if (index > ans.size() - 1) ans.add(0, new ArrayList<>());
        ans.get(ans.size() - index - 1).add(node.val);
        
        this.dfs(node.left, ans, index + 1);
        this.dfs(node.right, ans, index + 1);
        
    }

    public List<List<Integer>> levelOrderBottomBfs(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        // Stack<Queue<TreeNode>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while(!queue.isEmpty()) {
            
            Queue<TreeNode> newQueue = new LinkedList<>();
            List<Integer> cur = new ArrayList<>();

            while(!queue.isEmpty()) {
                TreeNode poll = queue.poll();

                cur.add(poll.val);

                if (poll.left != null) newQueue.add(poll.left);
                if (poll.right != null) newQueue.add(poll.right);
            }

            if (!cur.isEmpty()) ans.add(cur);

            queue = newQueue;
        }

        Collections.reverse(ans);

        return ans;
    }
}