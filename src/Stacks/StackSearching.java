package Stacks;

public class StackSearching {

    // Method to search for a target value in the stack
    public static int searchFor(ArrayStack s1, int target) {
        // Initialize position counter
        int pos = 0;
        // Flag to indicate if the target has been found
        boolean found = false;

        // Create a temporary stack to hold elements while searching
        ArrayStack s2 = new ArrayStack(s1.size());

        // Search for the target in the original stack
        while (!(s1.isEmpty())) {
            // Check if the top element is equal to the target
            if (s1.top == target) {
                found = true; // Target found
                break;
            }
            // Move the top element to the temporary stack
            s2.push(s1.pop());
            pos++; // Increment position
        }

        // Restore elements back to the original stack
        while (!(s2.isEmpty()) && !s1.isFull()) {
            s1.push(s2.pop());
        }

        // Return -1 if the target was not found
        if (!found) {
            return -1;
        }
        // Return the position where the target was found
        return pos;
    }

    // Main method to test the searchFor function
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5); // Create a new stack with capacity 5
        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack(); // Print the current elements in the stack

        // Search for element 2 in the stack
        System.out.println("Search for 2: " + searchFor(stack, 2));
        // Search for an element not in the stack (6)
        System.out.println("Search for 6: " + searchFor(stack, 6));
    }
}
