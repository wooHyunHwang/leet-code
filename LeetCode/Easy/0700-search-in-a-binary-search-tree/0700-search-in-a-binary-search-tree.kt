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
    fun searchBST(node: TreeNode?, `val`: Int): TreeNode? {
        if(node == null) return node
        if(node.`val` == `val`) return node;

        if(node.left != null) {
            val checked = searchBST(node.left, `val`)
            if(checked != null) return checked
        }

        if(node.right != null) return searchBST(node.right, `val`)

        return null
        
    }

}