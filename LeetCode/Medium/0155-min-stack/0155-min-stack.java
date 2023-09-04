class MinStack {

    int[] stack;
    int[] pq;
    int nextIdx;

    public MinStack() {
        stack = new int[8];
        pq = new int[8];
        nextIdx = 0;
    }
    
    public void push(int val) {
        if (stack.length - 1 < nextIdx) {
            stack = this.expandArray(stack, 8);
            pq = this.expandArray(pq, 8);
        }
        stack[nextIdx] = val;
        for (int i = 0; i < nextIdx; ++i) {
            if (pq[i] > val) {
                int temp = val;
                val = pq[i];
                pq[i] = temp;
            }
        }
        pq[nextIdx] = val;
        nextIdx++;
    }
    
    public void pop() {
        int temp = stack[nextIdx - 1];
        stack[nextIdx - 1] = 0;
        boolean find = false;
        for (int i = 0; i < nextIdx - 1; ++i) {
            if (pq[i] == temp) find = true;
            if (find) {
                pq[i] = pq[i+1];
            }
        }
        nextIdx--;
    }
    
    public int top() {
        return stack[nextIdx - 1];
    }
    
    public int getMin() {
        return pq[0];
    }

    private int[] expandArray(int[] arr, int size) {
        int[] expand = new int[arr.length + size];
        System.arraycopy(arr,0,expand,0,arr.length);
        return expand;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */