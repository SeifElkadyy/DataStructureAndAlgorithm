package Stacks;

import java.util.Arrays;

public class findNextGreaterElement {
    // Finds the next greater element for each element in the array (non-circular)
    public static int[] findNextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];  // Array to store results
        ArrayStack stack = new ArrayStack(arr.length);  // Stack to keep track of elements

        // Traverse the array from the end
        for (int i = arr.length - 1; i >= 0; i--) {
            // While stack is not empty and current element is greater than the top of the stack
            while (!stack.isEmpty() && arr[i] > stack.top()) {
                // The top of the stack has found its next greater element
                stack.pop();  // Remove it from the stack
            }
            // Assign the next greater element or -1 if not found
            if (!stack.isEmpty())
                result[i] = stack.top();
            else
                result[i] = -1;
            stack.push(arr[i]);  // Push the current element onto the stack
        }

        return result;  // Return the result array
    }

    // Finds the next greater element for each element in the array (circular)
    public static int[] findNextGreaterElementCircular(int[] arr) {
        int[] result = new int[arr.length];
        ArrayStack stack = new ArrayStack(arr.length);

        // Traverse the array twice to handle circular behavior
        for (int i = 0; i < arr.length * 2; i++) {
            int index = i % arr.length;  // Use modulo to wrap around
            // While stack is not empty and current element is greater than the top of the stack
            while (!stack.isEmpty() && arr[index] > stack.top()) {
                result[stack.pop()] = arr[index];  // Assign the next greater element
            }
            // Push the current index onto the stack
            stack.push(index);
        }

        // Fill remaining positions with -1 where no greater element was found
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;  // Assign -1 for those that have no next greater element
        }

        return result;  // Return the result array
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 10};
        int[] result = findNextGreaterElementCircular(arr);
        System.out.println("Next greater elements (circular): " + Arrays.toString(result));
    }
}
