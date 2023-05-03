class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

        val ans = arrayListOf<List<Int>>()

        val ansLeft = arrayListOf<Int>()
        val ansRight = arrayListOf<Int>()

        val dicLeft = BooleanArray(2001)
        val dicRight = BooleanArray(2001)

        // 1. Left 채움
        for(i in nums1) {
            dicLeft[i + 1000] = true
        }

        // 2. Right 체크와 동시에 dicRight 채움
        for(i in nums2) {
            dicRight[i + 1000] = true
            if(!dicLeft[i + 1000]) {
                dicLeft[i + 1000] = true
                ansRight.add(i)
            }
        }

        // 3. Left 체크
        for(i in nums1) {
            if(!dicRight[i + 1000]) {
                dicRight[i + 1000] = true
                ansLeft.add(i)
            }
        }

        ans.add(ansLeft)
        ans.add(ansRight)

        return ans;
    }

}