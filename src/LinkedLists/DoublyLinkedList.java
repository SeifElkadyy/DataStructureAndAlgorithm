package LinkedLists;

class DoubleLinkedList {
    public Object data;
    public DoubleLinkedList next;
    public DoubleLinkedList previous;

    public DoubleLinkedList(Object o) {
        data = o;
    }

    public String toString() {
        return data.toString();
    }
}

public class DoublyLinkedList {
    private DoubleLinkedList first; // reference to first link on list
    private DoubleLinkedList last; // reference to first link on list

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Object d) {
        DoubleLinkedList newLink = new DoubleLinkedList(d);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Object d) {
        DoubleLinkedList newDoubleLinkedList = new DoubleLinkedList(d);
        if (isEmpty())
            first = newDoubleLinkedList;
        else {
            last.next = newDoubleLinkedList;
            newDoubleLinkedList.previous = last;
        }
        last = newDoubleLinkedList;
    }

    public Object removeFirst() {
        Object temp = first.data;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public Object removeLast() {
        Object temp = last.data;
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public Object getFirst() {
        return first.data;
    }

    public Object getLast() {
        return last.data;
    }

    public void displayForward() {
        System.out.print("[ ");
        DoubleLinkedList current = first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    public void displayBackward() {
        System.out.print("[ ");
        DoubleLinkedList current = last;
        while (current != null) {
            System.out.print(current + " ");
            current = current.previous;
        }
        System.out.println("]");
    }

// --------------------------------------------------------------------
// Lab Questions

    //2.2.a) Sum of a list - Internal method
    public DoublyLinkedList sumOfTwoLists(DoublyLinkedList list) {
        DoublyLinkedList sumList = new DoublyLinkedList();

        DoubleLinkedList current1 = this.first;
        DoubleLinkedList current2 = list.first;

        while (current1 != null || current2 != null) {
            int sum = 0;

            if (current1 != null) {
                sum = sum + (int) current1.data;
                current1 = current1.next;
            }

            if (current2 != null) {
                sum = sum + (int) current2.data;
                current2 = current2.next;
            }

            sumList.insertLast(sum);
        }

        return sumList;
    }

    //2.2.b) Sum of List - External method
    public static DoublyLinkedList sumOfTwoListsAlt(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList result = new DoublyLinkedList();
        int carry = 0;
        while (!list1.isEmpty() || !list2.isEmpty()) {
            int sum = 0;
            if (!list1.isEmpty())
                sum += (int) list1.removeLast();
            if (!list2.isEmpty())
                sum += (int) list2.removeLast();
            sum += carry;
            carry = sum / 10;
            result.insertFirst(sum % 10);
        }
        if (carry > 0)
            result.insertFirst(carry);

        return result;
    }


    // 2.3.a) Implement the countIter() method that counts the number of elements in the list iteratively.
    public int countIter() {
        int count = 0;
        DoubleLinkedList current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //2.3.b) Implement the countRec() method that counts the number of elements in the list recursively.
    public int countRec() {
        return countRecHelper(first);
    }

    private int countRecHelper(DoubleLinkedList current) {
        if (current == null) {
            return 0;
        }

        return 1 + countRecHelper(current.next);
    }


    //2.6.a) Implement the contains() method that checks if the list contains a given object.
    public boolean contains(Object o) {
        DoubleLinkedList current = first;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //2.6.b) Implement the indexOf() method that returns the index of the first occurrence of a given object in the list.
    public boolean containsRec(Object o) {
        return containsRecHelper(first, o);
    }

    private boolean containsRecHelper(DoubleLinkedList current, Object o) {
        if (current == null) {
            return false;
        }
        if (current.data.equals(o)) {
            return true;
        }
        return containsRecHelper(current.next, o);
    }


    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.displayForward();

        System.out.println("\n");
        System.out.println("Count: " + list.countIter());
        System.out.println("Count: " + list.countRec());
        System.out.println("\n");
        System.out.println("Contains 3: " + list.contains(3));
        System.out.println("Contains 6: " + list.contains(6));
        System.out.println("\n");
        System.out.println("Contains 3: " + list.containsRec(3));
        System.out.println("Contains 6: " + list.containsRec(6));

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertFirst(1);
        list2.insertFirst(2);
        list2.insertFirst(3);

        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.insertFirst(1);
        list3.insertFirst(2);
        list3.insertFirst(3);

        list2.displayForward();
        DoublyLinkedList sumList = list2.sumOfTwoLists(list3);
        sumList.displayForward();

        DoublyLinkedList sumListAlt = DoublyLinkedList.sumOfTwoListsAlt(list2, list3);
        sumListAlt.displayForward();

    }
}
