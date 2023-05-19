class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var i = 0
        var sum = 0.0

        for(n in 0 .. k - 1) {
            sum += nums[n]
            ++i
        }

        var maxSum = sum

        while(i < nums.size) {

            sum += nums[i] - nums[i - k]

            maxSum = Math.max(maxSum, sum)

            ++i

        }

        return maxSum / k
    }
}