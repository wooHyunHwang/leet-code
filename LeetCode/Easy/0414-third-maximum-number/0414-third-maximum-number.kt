class Solution {
    fun thirdMax(nums: IntArray): Int {

        val dupCheck = mutableSetOf<Int>()

        var check = 0;
        val ans = intArrayOf(-2_147_483_648, -2_147_483_648, -2_147_483_648)

        for(no in nums) {
            if (dupCheck.contains(no)) {
                continue
            }

            dupCheck.add(no)

            if(ans[0] < no) {
                ans[2] = ans[1]
                ans[1] = ans[0]
                ans[0] = no
                check++
            } else if (ans[1] < no) {
                ans[2] = ans[1]
                ans[1] = no
                check++
            } else if (ans[2] <= no) {
                ans[2] = no
                check++
            }
        }

        if (check >= 3) return ans[2]
        return ans[0]
    }
}