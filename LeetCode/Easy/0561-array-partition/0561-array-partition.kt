class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        var ans = 0

        nums.sort()

        for(n in 0..nums.size - 1 step 2) {
            ans += nums[n]
        }

        return ans
    }

}