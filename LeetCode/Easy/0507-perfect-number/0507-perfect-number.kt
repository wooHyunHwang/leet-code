class Solution {
    fun checkPerfectNumber(num: Int): Boolean {
        if(num == 1) return false

        var sum: Int = 1
        val sqrt: Int = Math.sqrt(num.toDouble()).toInt()

        for(i: Int in 2 .. sqrt) {
            if (num % i == 0) {
                sum += i
                if(i != 1) {
                    if (i == sqrt && sqrt * sqrt == num) {
                        continue
                    }
                    sum += (num / i)
                }
            }
            if(sum > num) return false
        }

        return num == sum;
        
    }
}