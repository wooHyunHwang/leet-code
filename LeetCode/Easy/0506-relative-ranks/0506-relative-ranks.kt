class Solution {

    fun findRelativeRanks(score: IntArray): Array<String> {

        val sorted: IntArray = score.clone();
        sorted.sortDescending();

        val ans: Array<String> = Array(score.size){""}
        val ranked: IntArray = IntArray(sorted[0] + 1)

        for((idx, no) in sorted.withIndex()) {
            ranked[no] = idx
        }

        for((idx, no) in score.withIndex()) {
            if(ranked[no] >= 3) ans[idx] = (ranked[no] + 1).toString()
            else {
                if(ranked[no] == 0) ans[idx] = "Gold Medal"
                else if(ranked[no] == 1) ans[idx] = "Silver Medal"
                else if(ranked[no] == 2) ans[idx] = "Bronze Medal"
            }
        }

        return ans
        
    }

}