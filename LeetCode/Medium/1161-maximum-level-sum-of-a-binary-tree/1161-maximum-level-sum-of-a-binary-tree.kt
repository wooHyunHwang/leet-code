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
    fun maxLevelSum(root: TreeNode?): Int {
        if(root == null) return 0

        val sumAry = IntArray(10_001)
        sumAry[0] = Int.MIN_VALUE

        val lastDepth = cycle(root, sumAry, 1)

        var maxIdx = 0

        for(i in 1 .. lastDepth) {
            if(sumAry[maxIdx] < sumAry[i]) maxIdx = i
        }

        return maxIdx
    }

    fun cycle(node: TreeNode?, sumAry: IntArray, depth: Int): Int {

        if(node == null) return depth

        sumAry[depth] += node.`val`

        var diff = -1
        if(node.left != null) diff = cycle(node.left, sumAry, depth + 1)
        if(node.right != null) diff = Math.max(diff, cycle(node.right, sumAry, depth + 1))

        return Math.max(depth, diff)
    }
}