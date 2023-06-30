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
    var ans = 0
    fun goodNodes(root: TreeNode?): Int {
        
        if(root == null) return 0;
        
        this.ans = 0
        
        this.dfs(root, Integer.MIN_VALUE)
        
        return this.ans
    }
    
    private fun dfs(root: TreeNode?, receiveMax: Int) {
        if(root == null) return
        
        val curMax = Math.max(receiveMax, root.`val`)

        if(curMax <= root.`val`) this.ans++

        this.dfs(root.left, curMax)
        this.dfs(root.right, curMax)
    }

}