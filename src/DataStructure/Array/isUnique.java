package DataStructure.Array;

import DataStructure.Stacks.ArrayStack;

public class isUnique {
    public static boolean isUnique(ArrayStack in) {
        ArrayStack tempUnique = new ArrayStack(in.size());
        ArrayStack temp = new ArrayStack(in.size());
        boolean isUnique = true;

        // Use a loop to check all elements for uniqueness
        while (!in.isEmpty()) {
            int current = (int) in.pop(); // Get the current element from the input stack
            tempUnique.push(current); // Push the current element to tempUnique for restoration

            // Check if the current element is already in the stack
            while (!in.isEmpty() && isUnique) {
                if (current == (int) in.top()) {
                    isUnique = false; // Found a duplicate
                } else {
                    temp.push(in.pop()); // Move the non-duplicate element to temp
                }
            }

            // Restore non-duplicate elements back to the input stack
            while (!temp.isEmpty()) {
                in.push(temp.pop());
            }
        }

        // Restore the original stack from tempUnique
        while (!tempUnique.isEmpty()) {
            in.push(tempUnique.pop());
        }

        return isUnique; // Return whether all elements are unique
    }


    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(10);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(5);
        s.push(5);
        s.push(6);
        s.push(9);
        s.push(2);

        isUnique(s);

        s.printStack();
    }
}
