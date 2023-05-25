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
    fun leafSimilar(root1: TreeNode, root2: TreeNode): Boolean {

        var qu: Queue<Int> = putDfs(root1, LinkedList())
        val result = getDfs(root2, qu)

        if(qu.isEmpty() && result) return result
        return false
    }

    fun putDfs(node: TreeNode, qu: Queue<Int>): Queue<Int> {
        
        if(node.left == null && node.right == null) {
            qu.add(node.`val`)
            return qu
        }

        if(node.left != null) {
            putDfs(node.left, qu)
        }

        if(node.right != null) {
            putDfs(node.right, qu)
        }

        return qu
    }

    fun getDfs(node: TreeNode, qu: Queue<Int>): Boolean {

        if(node.left == null && node.right == null) {
            val no = qu.poll()
            if(no != null && no == node.`val`) return true
            else return false
        }

        if(node.left != null) {
            if(!getDfs(node.left, qu)) return false
        }

        if(node.right != null) {
            if(!getDfs(node.right, qu)) return false
        }
        
        return true
    }
}