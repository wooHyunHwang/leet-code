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
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNodeV2> map = new HashMap<>();
        
        for (int[] info : descriptions) {
            
            TreeNodeV2 node = map.getOrDefault(info[0], new TreeNodeV2(info[0]));

            map.put(info[0], node);

            TreeNodeV2 next = map.getOrDefault(info[1], new TreeNodeV2(info[1]));

            if (info[2] == 0) node.right = next;
            else node.left = next;

            next.parent = node;

            map.put(info[1], next);
        }

        return map.get(descriptions[0][0]).getRoot();
    }

    public static class TreeNodeV2 extends TreeNode {

        public TreeNodeV2 parent = null;

        public TreeNodeV2(int val) {
            super(val);
        }

        public TreeNodeV2 getRoot() {
            if (parent != null) return parent.getRoot();
            return this;
        }
    }
}