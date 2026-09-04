class MinStack {
    List<Integer> min;
    Stack<Integer> stack;

    public MinStack() {
        this.min = new ArrayList<>();
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        min.add(val);
        stack.push(val);
        Collections.sort(min);
    }
    
    public void pop() {
        min.remove(min.indexOf(stack.pop()));
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.get(0);
    }
}
