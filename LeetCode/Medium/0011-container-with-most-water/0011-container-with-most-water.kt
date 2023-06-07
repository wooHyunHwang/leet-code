class Solution {
    fun maxArea(height: IntArray): Int {
        
        var left = 0
        var right = height.size - 1
        var ans = 0

        while(left != right) {
            ans = Math.max(
                ans,
                this.calc(height[left], height[right], right - left)
            )

            if(height[left] < height[right]) left++
            else right--
        }

        return ans
    }

    fun calc(leftV: Int, rightV: Int, length: Int): Int {
        return Math.min(leftV, rightV) * length
    }
}