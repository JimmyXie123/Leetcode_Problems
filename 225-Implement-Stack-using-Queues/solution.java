class MyStack {
    Queue<Integer> queue1 = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();
    // Push element x onto stack.
    private void moveItems(){
        while(queue1.size()>1){
            queue2.offer(queue1.poll());
        }   
    } 
    private void swap(){
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public void push(int x) {
        queue1.push(x);                      
    }

    // Removes the element on top of the stack.
    public void pop() {
        moveItems();
        queue1.poll();
        swap();
    }

    // Get the top element.
    public int top() {
        moveItems();
        int result = 0;
        if(queue1.size()!=0){
            queue1.poll().intValue();
        }
        swap();
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}