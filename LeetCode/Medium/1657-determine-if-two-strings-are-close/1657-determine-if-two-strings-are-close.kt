class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        
        val left = IntArray(26)
        val right = IntArray(26)

        for(i in 0 .. word1.length - 1) left[word1[i] - 'a']++
        for(i in 0 .. word2.length - 1) right[word2[i] - 'a']++

        for(i in 0.. 25) {
            if(left[i] == 0 && right[i] != 0) return false
            if(left[i] != 0 && right[i] == 0) return false
        }
        
        left.sortDescending()
        right.sortDescending()

        for(i in 0.. 25) {
            if(left[i] != right[i]) return false
            if(left[i] == 0) return true
        }

        return true
    }
}