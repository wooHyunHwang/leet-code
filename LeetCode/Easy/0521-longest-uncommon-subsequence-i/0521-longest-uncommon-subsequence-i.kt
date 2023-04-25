class Solution {
    fun findLUSlength(a: String, b: String): Int {
        if(b == a) return -1;
        return Math.max(a.length, b.length)
    }
}