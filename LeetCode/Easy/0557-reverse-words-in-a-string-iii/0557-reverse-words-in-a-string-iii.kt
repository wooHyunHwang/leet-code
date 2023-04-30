class Solution {
    fun reverseWords(s: String): String {
        val sb: StringBuilder = StringBuilder()

        val sAry = s.split(" ")

        for( (i, str) in sAry.withIndex()) {
            val cAry = str.toCharArray()

            for ( j in cAry.lastIndex downTo 0) {
                sb.append(cAry[j])
            }

            if (i != sAry.lastIndex) sb.append(" ");
        }

        return sb.toString()
    }
}