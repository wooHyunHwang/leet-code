class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        
        for(i in 1 .. matrix.size - 1) {
            for(j in 1 .. matrix[i].size - 1) {
                if(matrix[i][j] != matrix[i-1][j-1]) return false
            }
        }

        return true
    }
}