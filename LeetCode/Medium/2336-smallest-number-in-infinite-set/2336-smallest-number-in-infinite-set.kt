class SmallestInfiniteSet2() {

    val queue = PriorityQueue<Int>()
    var cur = 1

    fun popSmallest(): Int {

        if(queue.size > 0 && cur > queue.peek()) {
            return queue.poll()
        } else {
            val ans = cur
            cur++
            return ans
        }
        

    }

    fun addBack(num: Int) {
        if(num < cur && !queue.contains(num)) queue.add(num)
    }

}

class SmallestInfiniteSet() {

    val arr = BooleanArray(1_001)
    var smallIdx = 1

    fun popSmallest(): Int {

        val pop = smallIdx

        arr[smallIdx] = true

        setNextSmallIdx(pop)

        return pop
    }

    fun addBack(num: Int) {
        if(arr[num]) {
            arr[num] = false
            smallIdx = if(smallIdx > num) {num} else {smallIdx}
        }
    }

    fun setNextSmallIdx(lastIdx: Int) {
        for(i in lastIdx .. 1_000) {
            if(!arr[i]) {
                smallIdx = i
                break
            }
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */