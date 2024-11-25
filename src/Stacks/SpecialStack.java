package Stacks;

public class SpecialStack {
    public ArrayStack stack;
    public ArrayStack minStack;

    // Constructor
    public SpecialStack(int maxSize) {
        stack = new ArrayStack(maxSize);
        minStack = new ArrayStack(maxSize);
    }

    // Push operation
    public void push(int x) {
        stack.push(x); // Push onto the main stack

        if (minStack.isEmpty() || x <= minStack.top()) {
            minStack.push(x); // Push onto minStack
        }
    }

    // Pop operation
    public int pop() {

        int popped = stack.pop();

        if (popped == minStack.top()) {
            minStack.pop();
        }

        return popped;
    }

    // Top operation
    public int top() {
        return stack.top(); // Return the top element from the main stack
    }

    // Get minimum operation
    public int getMin() {

        return minStack.top(); // Return the top of minStack, which is the current minimum
    }

    // Other operations as per your Stacks.ArrayStack implementation
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.isFull();
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        stack.printStack(); // Print the main stack
    }

    public int search(int target) {
        return stack.search(target); // Search in the main stack
    }

    public void reverse() {
        stack.reverse(); // Reverse the main stack
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack(5);

        specialStack.push(3);
        specialStack.push(5);
        System.out.println("Current stack:");
        specialStack.printStack();
        System.out.println("Min element: " + specialStack.getMin());

        specialStack.push(2);
        specialStack.push(1);
        specialStack.push(4);

        System.out.println("After pushing more elements:");
        specialStack.printStack();
        System.out.println("Min element: " + specialStack.getMin());

        specialStack.pop();
        System.out.println("After popping one element:");
        specialStack.printStack();
        System.out.println("Min element: " + specialStack.getMin());

        specialStack.pop();
        System.out.println("After popping another element:");
        specialStack.printStack();
        System.out.println("Min element: " + specialStack.getMin());
    }
}
