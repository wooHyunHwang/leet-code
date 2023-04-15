class Solution {
    fun constructRectangle(area: Int): IntArray {
        val sqrt = Math.sqrt(area.toDouble()).toInt()
        var max: Int = 1

        for(i in 2..sqrt) {
            if (area % i == 0) max = i
        }

        return intArrayOf(area / max, max)
    }
}