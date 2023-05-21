class Solution {
    fun pivotIndex(nums: IntArray): Int {
        var TOTAL = 0
        var leftSum = 0

        for (n in nums) {
            TOTAL += n
        }

        for ((i, v) in nums.withIndex()) {

            if(i != 0) leftSum += nums[i - 1]

            if(TOTAL - leftSum - nums[i] == leftSum) return i
        }

        return -1
    }

}