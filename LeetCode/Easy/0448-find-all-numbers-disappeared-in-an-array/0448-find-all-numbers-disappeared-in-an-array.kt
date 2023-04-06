class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {

        val checker = IntArray(nums.size+1) {0}
        val ans: MutableList<Int> = mutableListOf<Int>()

        for (n in nums) {
            checker[n]++
        }

        for ((idx, check) in checker.withIndex()) {
            if (idx == 0) continue
            if (check == 0) ans.add(idx)
        }

        return ans
    }
}