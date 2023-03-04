class MyQueue {

    private Stack<Integer> stk;

    public MyQueue() {
        stk = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        // 첫번째 값 out
        Stack<Integer> temp = new Stack<>();
        while(!stk.isEmpty()) {
            temp.push(stk.pop());    
        }
        int pop = temp.pop();
        while(!temp.isEmpty()) {
            stk.push(temp.pop());    
        }
        return pop;
    }
    
    public int peek() {
        // 첫번째 값 return
        Stack<Integer> temp = new Stack<>();
        while(!stk.isEmpty()) {
            temp.push(stk.pop());    
        }
        int pop = temp.pop();
        stk.push(pop);
        while(!temp.isEmpty()) {
            stk.push(temp.pop());
        }
        return pop;
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */