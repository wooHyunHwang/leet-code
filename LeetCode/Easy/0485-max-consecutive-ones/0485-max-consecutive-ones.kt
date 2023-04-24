class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max: Int = 0
        var temp: Int = 0

        for (num in nums) {
            if(num == 0) {
                max = Math.max(max, temp)
                temp = 0
            } else {
                temp++
            }
        }
        return Math.max(max, temp)
    }
}
