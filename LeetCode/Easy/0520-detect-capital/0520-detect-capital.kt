class Solution {
    fun detectCapitalUse(word: String): Boolean {
        val cAry: CharArray = word.toCharArray()
        if(cAry.size <= 1) return true

        // 첫번째 글자가 true 인 경우 대문자
        val first: Boolean = 'A' <= cAry[0] && cAry[0] <= 'Z'
        // 두번째 글자가 true 인 경우 대문자
        val second: Boolean = 'A' <= cAry[1] && cAry[1] <= 'Z'

        // 첫, 두 케이스
        if(!first && second) return false

        // 두, 셋 케이스
        for(i: Int in 2 .. cAry.size - 1) {
            val cur: Boolean = 'A' <= cAry[i] && cAry[i] <= 'Z'
            if(second != cur) return false
        }

        return true
    }
}