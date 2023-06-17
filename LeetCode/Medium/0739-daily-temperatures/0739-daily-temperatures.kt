class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        
        val len = temperatures.size
        var answer = IntArray(len)
        
        var lastHot = temperatures[len - 1]
        
        for(i in temperatures.indices.reversed()) {
            if(temperatures[i] >= lastHot) {
                lastHot = temperatures[i]
                continue;
            }
            
            var day = 1
            while(temperatures[i + day] <= temperatures[i]) {
                day += answer[i + day]
            }
            answer[i] = day
        }
        
        return answer
    }
}