class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var ans = 0

        for(i in 0 .. grid.size - 1) {
            for(j in 0 .. grid[i].size - 1) {
                if(grid[i][j] < 0) {
                    ans += grid[i].size - j
                    break
                }
            }
        }

        return ans
    }
}