class RecentCounter() {

    val counter = LinkedList<Int>()

    fun ping(t: Int): Int {
        
        this.counter.addLast(t + 3000)

        while(this.counter.getFirst() < t) {
            this.counter.remove()
        }

        return this.counter.size
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */