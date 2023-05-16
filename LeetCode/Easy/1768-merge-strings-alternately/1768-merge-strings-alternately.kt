class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()

        val iLen = word1.length
        val jLen = word2.length
        var i = 0
        var j = 0

        while(i < iLen || j < jLen) {
            if(i < iLen) sb.append(word1[i++])
            if(j < jLen) sb.append(word2[j++])
        }

        return sb.toString()
    }
}