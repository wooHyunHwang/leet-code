class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        for (int i = 0; i < queue.size(); ++i) {
            if (i != queue.size() - 1) {
                queue.add(queue.poll());
            }
        }
        return queue.poll();
    }
    
    public int top() {
        for (int i = 0; i < queue.size(); ++i) {
            if (i != queue.size() - 1) {
                queue.add(queue.poll());
            }
        }
        int top = queue.poll();
        queue.add(top);
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */