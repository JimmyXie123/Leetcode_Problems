public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        //minStack = new Stack();
        min = null;
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(), x));
        }
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */