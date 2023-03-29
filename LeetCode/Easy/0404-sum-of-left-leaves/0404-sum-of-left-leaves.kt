/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {

        if (isLeaf(root)) return 0;
        return find(0, root);
    }

    private fun find(sum: Int, node: TreeNode?): Int {
        var add = sum;
        // left
        if (node?.left != null) {
            if(isLeaf(node.left)) {
                add += node.left.`val` ?: 0;
            } else {
                add = find(add, node.left);
            }
        }

        // right
        if (node?.right != null) {
            add = find(add, node.right);
        }

        return add;
    }

    private fun isLeaf(node: TreeNode?): Boolean {
        return node?.left == null && node?.right == null;
    }
}