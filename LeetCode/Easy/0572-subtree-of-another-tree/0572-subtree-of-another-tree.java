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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root.val == subRoot.val) {
            boolean checked = isRealSubtree(root, subRoot);
            if(checked) return checked;
        }
        
        if(root.left != null) {
            boolean checked = isSubtree(root.left, subRoot);
            if(checked) return checked;
        }

        if(root.right != null) {
            return isSubtree(root.right, subRoot);
        }

        return false;
    }

    // DFS in DFS 서브트리 탐색
    public boolean isRealSubtree(TreeNode node, TreeNode nextNode) {

        // System.out.println("확인하는 현재 루틴 : " + node.val);

        // 안될 조건 탐색
        if(node.val != nextNode.val) return false;
        if(
            (node.left != null && nextNode.left == null) ||
            (node.left == null && nextNode.left != null)
        ) {
            return false;
        }
        if(
            (node.right != null && nextNode.right == null) ||
            (node.right == null && nextNode.right != null)
        ) {
            return false;
        }

        // 재귀
        boolean checkLeft = true;
        boolean checkRight = true;
        if(node.left != null) {
            checkLeft = isRealSubtree(node.left, nextNode.left);
        }

        if(node.right != null) {
            checkRight = isRealSubtree(node.right, nextNode.right);
        }

        return checkLeft && checkRight;
    }
}
















