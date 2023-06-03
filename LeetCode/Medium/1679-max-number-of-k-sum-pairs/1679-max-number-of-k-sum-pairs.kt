class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        
        if(nums.size == 0) return 0
        
        nums.sort()
        
        var ans = 0
        var left = 0
        var right = nums.size - 1

        while(left < right) {
            
            val sum = nums[left] + nums[right]
            /*
            print(left)
            print(" / ")
            println(right)

            print(nums[left])
            print(" + ")
            print(nums[right])
            print(" = ")
            println(sum)
            */

            if(sum == k) {
                ans++
                left++
                right--
            }
            else if (sum < k) left++
            else right--
        }
        
        return ans
        
    }
}