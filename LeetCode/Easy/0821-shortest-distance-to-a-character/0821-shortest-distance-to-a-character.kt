class Solution {
    fun shortestToChar(s: String, c: Char): IntArray {

        val ans = IntArray(s.length)

        var before = 10_000

        for(i in 0 .. s.length - 1) {

            // 기본 : 이전 찾은값과 비교
            if(s[i] != c) {
                ans[i] = Math.abs(before - i)
                continue
            }

            
            // 대상 찾을 경우 역행해서 기록
            before = i
            ans[i] = 0

            var reverse = i - 1
            var distance = 1
            while(reverse >= 0) {

                if(distance < ans[reverse]) ans[reverse--] = distance++
                else break
            }
        }

        return ans
    }
}