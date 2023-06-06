class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        
        arr.sort()

        val diff = arr[1] - arr[0]

        for(i in 2 .. arr.size - 1) {
            if(diff != arr[i] - arr[i-1]) {
                return false
            }
        }
        return true
    }
}