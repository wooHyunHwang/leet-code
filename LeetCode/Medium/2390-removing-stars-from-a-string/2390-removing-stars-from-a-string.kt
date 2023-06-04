class Solution {
    fun removeStars(s: String): String {

        var idx = 0
        val arr = s.toCharArray()

        for(c in arr) {
            if(c == '*') idx = Math.max(idx - 1, 0)
            else arr[idx++] = c
        }

        return String(arr, 0, idx)
        
    }
}