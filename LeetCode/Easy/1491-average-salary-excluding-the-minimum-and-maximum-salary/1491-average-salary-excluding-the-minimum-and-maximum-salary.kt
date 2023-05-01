class Solution {
    fun average(salary: IntArray): Double {
        var ans: Double = 0.0

        var max: Int = Int.MIN_VALUE
        var min: Int = Int.MAX_VALUE

        for(s in salary) {
            ans += s;
            max = Math.max(max, s)
            min = Math.min(min, s)
        }


        if(max == min) {
            ans -= max
            return ans / (salary.size - 1)
        } else {
            ans -= max
            ans -= min
            return ans / (salary.size - 2)
        }
        
    }
}