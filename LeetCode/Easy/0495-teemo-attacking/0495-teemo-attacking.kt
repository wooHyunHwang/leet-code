class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if(timeSeries.size == 0) return 0
        if(timeSeries.size == 1) return duration

        var ans: Int = duration
        var end: Int = timeSeries[0] + duration

        for (i in 1 .. timeSeries.size - 1){

            val newEndTime = timeSeries[i] + duration

            if (end < timeSeries[i]) {
                // 새로 맞음
                ans += duration
                end = newEndTime
            } else {
                // 독 연장
                ans += newEndTime - end
                end = newEndTime
            }
        }

        return ans
    }
}