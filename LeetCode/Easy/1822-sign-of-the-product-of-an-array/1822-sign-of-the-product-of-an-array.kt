class Solution {
    
    fun arraySign(nums: IntArray): Int {

        if(nums.size == 0) return 0

        var minus: Int = 0

        for(n in nums) {
            if(n < 0) {
                minus++
            } else if (n == 0) {
                return 0
            }
        }

        return if (minus % 2 == 0) 1 else -1
        
    }

}