package Array;

public  class LinearArray {

    // a counter that keeps track of the number of elements in the array
    int itemCount;
    int[] array;

    //constructor
    public LinearArray(int maxSize)
    {
        itemCount = 0;
        array = new int[maxSize];
    }

    // method to insert elements at the end of an unordered array
    //Time complexity: O(1)
    public void insertLast(int x)
    {
        if(itemCount < array.length)
            array[itemCount++] = x;
        else
            System.out.print("Array is Full");
    }

    // method to insert elements at the beginning of an unordered array
    //Time complexity: O(n)
    public void insertFirst(int x)
    {
        if (itemCount < array.length)
        {
            for(int i = itemCount; i > 0; i--)
                array[i] = array[i-1];
            array[0] = x;
            itemCount++;
        }
        else
            System.out.print("Array is Full");
    }

    // linear search: method to search any array
    //Time complexity: O(n)
    public int linearSearch(int x)
    {
        for(int i = 0; i < itemCount; i++)
            if(array[i] == x)
                return i;

        return -1;
    }

    // delete element from the array
    //Time complexity: O(n)
    public void delete(int x)
    {
        // get the position of the element
        int pos = this.linearSearch(x);
        if(pos == -1)
            System.out.println("Element not found!");
        else
        {
            //shift the rest of the elements by one position
            for(int i = pos; i < itemCount - 1; i++)
                array[i] = array[i+1];
            itemCount--;
        }
    }

    public void displayArray()
    {
        // print the array
        System.out.print("Array: ");
        for(int i = 0; i < itemCount; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String [] args)
    {
        LinearArray a = new LinearArray(10);
        a.insertLast(3);
        a.insertLast(7);
        a.insertFirst(8);
        a.displayArray();
        System.out.println("Count: " + a.itemCount);
        System.out.println("Position of 8: " + a.linearSearch(8));
        System.out.println("Position of 5: " + a.linearSearch(5));
        a.delete(33);
        a.delete(3);
        System.out.println("Count: " + a.itemCount);
    }
}
