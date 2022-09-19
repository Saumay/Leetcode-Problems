class MyQueue {

    Deque<Integer> st1;
    Deque<Integer> st2;
    int front;
    
    public MyQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(st1.isEmpty())
            front = x;
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    public int peek() {
        return !st2.isEmpty() ? st2.peek() : front;
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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