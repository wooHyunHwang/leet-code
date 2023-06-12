class Solution {
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
        
        if(ops.size == 0) return m * n
        
        var leftMin = m
        var rightMin = n
        
        for(i in 0 .. ops.size - 1) {
            leftMin = Math.min(leftMin, ops[i][0])
            rightMin = Math.min(rightMin, ops[i][1])
        }
        return leftMin * rightMin
    }
}