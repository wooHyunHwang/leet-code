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

    List<Integer> l = null;
    List<Integer> r = null;

    public boolean isSymmetric(TreeNode root) {

        l = new ArrayList<>();
        r = new ArrayList<>();

        leftRecur(root);
        rightRecur(root);

        if (l.size() != r.size()) {
            return false;
        } else {
            for(int i = 0; i < l.size(); ++i) {
                if ( l.get(i) != r.get(i) ) return false;
            }
            return true;
        }
    }

    public void leftRecur(TreeNode root) {
        if( root == null ) {
            l.add(null);
            return;
        }

        l.add(root.val);

        leftRecur(root.left);
        leftRecur(root.right);

    }
    public void rightRecur(TreeNode root) {
        if( root == null ) {
            r.add(null);
            return;
        }

        r.add(root.val);

        rightRecur(root.right);
        rightRecur(root.left);
    }
}