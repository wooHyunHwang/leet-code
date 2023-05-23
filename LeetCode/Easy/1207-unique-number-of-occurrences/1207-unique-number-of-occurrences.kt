class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {

        val count = IntArray(2_001)
        val checked = BooleanArray(2_001)
        val occurrenceSet = BooleanArray(1_001)

        for(i in 0 .. arr.size - 1) {
            count[arr[i] + 1000]++
        }

        for(i in 0 .. arr.size - 1) {
            val idx = arr[i] + 1000;

            if(checked[idx]) continue

            if(occurrenceSet[count[idx]]) return false
            occurrenceSet[count[idx]] = true
            checked[idx] = true
        }

        return true
        
    }
}