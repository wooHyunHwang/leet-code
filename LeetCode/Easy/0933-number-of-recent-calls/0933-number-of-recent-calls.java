class RecentCounter {

    private LinkedList<Integer> counter;

    public RecentCounter() {
        this.counter = new LinkedList<>();
    }
    
    public int ping(int t) {

        this.counter.addLast(t + 3000);
        
        while(this.counter.getFirst() < t) {
            this.counter.remove();
        }
        return this.counter.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */