class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        val s = candyType.toSet()

        return Math.min(s.size, candyType.size / 2)
    }
}