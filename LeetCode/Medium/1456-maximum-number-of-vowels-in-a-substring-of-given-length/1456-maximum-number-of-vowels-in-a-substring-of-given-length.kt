class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var ans = 0
        var check = 0;
        val sAry = IntArray(s.length)
        val scAry = s.toCharArray()

        for((i, sc) in scAry.withIndex()) {
            if(sc == 'a' || sc == 'e' || sc == 'i' || sc == 'o' || sc == 'u') {
                check++
            }
            sAry[i] = check
        }

        for(i in k-1 .. sAry.size - 1) {

            if (i == k - 1) {
                ans = Math.max(ans, sAry[i])
            } else {
                ans = Math.max(ans, sAry[i] - sAry[i - k])
            }

        }

        return ans
    }
}
