// doubly list GG
class StockSpanner4 {

    private DoublyList last;

    public StockSpanner4() {
        last = new DoublyList(0);
    }
    
    public int next(int price) {

        DoublyList data = new DoublyList(price);

        int span = 1;

        data.setSpan(span);

        return span;

    }

    public static class DoublyList {

        private DoublyList head;
        private DoublyList tail;

        private final int price;
        private int span;

        protected DoublyList(int price) {
            this.price = price;
            this.span = 0;
        }

        protected void setHead(DoublyList head) { this.head = head; }
        protected DoublyList getHead() { return this.head; }
        protected void setTail(DoublyList tail) { this.tail = tail; }
        protected DoublyList getTail() { return this.tail; }

        protected void setSpan(int span) { this.span = span; }
        protected int getPrice() { return this.price; }
        protected int getSpan() { return this.span; }
    }
}

// linkedlist
class StockSpanner {

    private LinkedList<Data> linkedList;

    public StockSpanner() {
        linkedList = new LinkedList<>();
    }
    
    public int next(int price) {

        Data data = new Data(price);

        int idx = this.linkedList.size() - 1;
        int span = 1;

        while(idx >= 0) {
            if(this.linkedList.get(idx).getPrice() <= price) {
                // System.out.println(idx + " / " + this.linkedList.get(idx).getSpan());
                span += this.linkedList.get(idx).getSpan();
                idx -= this.linkedList.get(idx).getSpan();
            } else {
                break;
            }
            // System.out.println("span ## " + span);
        }
        // System.out.println("return ###### " + span);

        data.setSpan(span);
        linkedList.add(data);

        return span;
    }

    public static class Data {
        private final int price;
        private int span;

        protected Data(int price) {
            this.price = price;
            this.span = 0;
        }
        protected void setSpan(int span) { this.span = span; }
        protected int getPrice() { return this.price; }
        protected int getSpan() { return this.span; }
    }
}
// array
class StockSpanner2 {
    private final int width = 10240;
    private int[] stack;
    private int idx;

    public StockSpanner2() {
        stack = new int[this.width];
        idx = 0;
    }

    private void addStack(int price) {
        if(this.stack.length == this.idx + 1) {
            this.stack = Arrays.copyOf(this.stack, this.stack.length + this.width);
        }
        this.stack[this.idx++] = price;
    }
    
    public int next(int price) {

        this.addStack(price);
        
        int ans = 0;
        for(int i = this.idx - 1; i >= 0; --i) {
            // System.out.println(i + " : " + stack[i]);
            if(this.stack[i] <= price) ans++;
            else return ans;
        }
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */