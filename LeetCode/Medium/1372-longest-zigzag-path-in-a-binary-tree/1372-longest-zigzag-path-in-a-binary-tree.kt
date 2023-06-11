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
    fun longestZigZag(root: TreeNode?): Int {
        
        if(root == null) return 0

        var left = 0
        var right = 0

        if(root.left != null) left = find(root.left, 1, false)
        if(root.right != null) right = find(root.right, 1, true)

        return Math.max(left, right)
    }

    /**
     * @param wayCount 지그재그 한 건수
     * @param direction 이전 방향 false: left, true: right
     */
    fun find(node: TreeNode, wayCount: Int, direction: Boolean): Int {

        if(node.left == null && node.right == null) return wayCount;

        val left = if(node.left == null) {
            0
        }
        else {
            find(
                node.left,
                if(direction) {wayCount + 1} else {1},
                false
            )
        }

        val right = if(node.right == null) {
            0
        }
        else {
            find(
                node.right,
                if(direction) {1} else {wayCount + 1},
                true
            )
        }

        return Math.max(
            wayCount,
             Math.max(left, right)
        )
    }

}