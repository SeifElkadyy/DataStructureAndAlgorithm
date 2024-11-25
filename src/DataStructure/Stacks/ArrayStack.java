package DataStructure.Stacks;

public class ArrayStack {
    private int[] stackArray; // The array that holds the items
    public int top; // Index of top item in the stack
    private int maxSize; // Maximum Capacity for the stack

    // constructor

    public ArrayStack(int s) {
        maxSize = s; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    } // end of constructor

    public void push(int i) {
        top++;
        stackArray[top] = i; // increment top, insert item
    }

    public int pop() {
        int result = stackArray[top];
        top--;
        return result; // decrement top, return item
    }

    public int top() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == (maxSize - 1));
    }

    public int size(){
        return maxSize;
    }

    public void printStack(){
        if(top == -1){
            System.out.println("Stack is empty!!\n");

        }
        else{
            System.out.println(stackArray[top] + " <- top");
            for(int i = top-1; i>=0;i--){
                System.out.println(stackArray[i]);

            }
        }
    }
    public int search(int target){
        for(int i = top; i>=0; i--){
            if(stackArray[i] == target){
                return i;
            }
        }
        return -1;
    }
    public void reverse()
    {
        for(int i=0; i<(top+1)/2; i++)
        {
            int temp = stackArray[i];
            stackArray[i] = stackArray[top-i];
            stackArray[top-i] = temp;
        }
    }



    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        System.out.println("Search for 3: " + stack.search(3));
        System.out.println("Search for 6: " + stack.search(6));
    }
}