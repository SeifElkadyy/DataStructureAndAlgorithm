package DataStructure.Array;

public class LinearSortedArray {
    int Count;
    int[] array;

    public LinearSortedArray(int MaxSize) {
        Count = 0;
        array = new int[MaxSize];
    }

    void orderedInsert(int x) {
        if (Count < array.length) {
            int Pos = 0;
            while (Pos < Count && array[Pos] < x) {
                Pos++;
            }
            for (int k = Count; k > Pos; k--) { // Fix the loop to shift elements correctly
                array[k] = array[k - 1];
            }
            array[Pos] = x;
            Count++;
        } else {
            System.out.println("DataStructure.Array is full");
        }
    }

    int binarySearchIter(int x) {
        int LowerBound = 0;
        int UpperBound = Count - 1;
        while (LowerBound <= UpperBound) {
            int Pos = (LowerBound + UpperBound) / 2;
            if (array[Pos] == x) {
                return Pos;
            } else if (x > array[Pos]) {
                LowerBound = Pos + 1;
            } else {
                UpperBound = Pos - 1;
            }
        }
        return -1;
    }

    int binarySearchRec(int x) {
        return binary(0, Count - 1, x);
    }

    private int binary(int lowerBound, int upperBound, int x) {
        if (lowerBound > upperBound)
            return -1;
        int pos = lowerBound + (upperBound - lowerBound) / 2;
        if (array[pos] == x)
            return pos;
        else if (x > array[pos])
            return binary(pos + 1, upperBound, x);
        else
            return binary(lowerBound, pos - 1, x);
    }

    public void delete(int x) {
        int pos = this.binarySearchIter(x);
        if (pos == -1)
            System.out.println("Element not found!");
        else {
            for (int i = pos; i < Count - 1; i++)
                array[i] = array[i + 1];
            Count--;
        }
    }

    public void displayArray() {
        System.out.print("Sorted DataStructure.Array: ");
        for (int i = 0; i < Count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinearSortedArray b = new LinearSortedArray(10);
        b.orderedInsert(5);
        b.orderedInsert(3);
        b.orderedInsert(1);
        b.orderedInsert(44);
        b.displayArray();
        System.out.println("Iteratively, 5 at: " + b.binarySearchIter(5));
        System.out.println("Recursively, 6 at: " + b.binarySearchRec(6));
        System.out.println("Recursively, 5 at: " + b.binarySearchRec(5));
    }
}
