class SmallestInfiniteSet {

    private final boolean[] arr;
    private int smallIdx;

    public SmallestInfiniteSet() {
        this.arr = new boolean[1_001];
        this.smallIdx = 1;
    }
    
    public int popSmallest() {

        int ans = this.smallIdx;

        this.arr[this.smallIdx] = true;

        this.setNextSmallestIdx(ans);

        return ans;
    }
    
    public void addBack(int num) {
        if(this.arr[num]) {
            this.arr[num] = false;
            this.smallIdx = this.smallIdx > num ? num : this.smallIdx;
        }
    }

    private void setNextSmallestIdx(int lastIdx) {
        for(int i = lastIdx; i < 1_001; ++i) {
            if(!this.arr[i]) {
                this.smallIdx = i;
                break;
            }
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */