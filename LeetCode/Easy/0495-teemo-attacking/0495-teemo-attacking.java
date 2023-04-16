class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        if(timeSeries.length == 0) return 0;
        if(timeSeries.length == 1) return duration;

        int ans = duration;
        int endTime = timeSeries[0] + duration;

        for(int i = 1; i < timeSeries.length; ++i) {
            int newTime = timeSeries[i] + duration;
            if(endTime < timeSeries[i]) {
                // 새로운 독에 걸림
                ans += duration;
                endTime = newTime;
            } else {
                // 이전 독 연장
                ans += newTime - endTime;
                endTime = newTime;
            }
        }


        return ans;
    }
}