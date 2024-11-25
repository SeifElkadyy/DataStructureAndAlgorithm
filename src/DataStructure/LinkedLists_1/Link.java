package DataStructure.LinkedLists_1;

class Link
{
    public Object data;
    public DoubleLinkedList next;

    public Link(Object o)
    {
        this.data = o;
        this.next = null;
    }

    public String toString()
    {
        return data.toString();
    }
}

class LinkList{
    private DoubleLinkedList head;

    public LinkList()
    {
        head = null;
    }

    public void insertFirst(Object o) {
        DoubleLinkedList newDoubleLinkedList = new DoubleLinkedList(o);
        newDoubleLinkedList.next = head;
        head = newDoubleLinkedList;
    }

    public Object removeFirst() {
        Object res = head.data;
        head = head.next;
        return res;
    }

    public Object getFirst() {
        return head.data;
    }

    public void insertLast(Object o) {
        DoubleLinkedList newDoubleLinkedList = new DoubleLinkedList(o);
        if(head==null) {
            head = newDoubleLinkedList;
            return;
        }
        DoubleLinkedList current = head;
        while(current.next != null)
            current = current.next;
        current.next = newDoubleLinkedList;
    }

    public Object removeLast() {
        if(head.next == null) {
            Object res = head.data;
            head = null;
            return res;
        }
        DoubleLinkedList current = head;
        while(current.next.next != null)
            current = current.next;
        Object res = current.next.data;
        current.next = null;
        return res;
    }

    public Object getLast()
    {
        DoubleLinkedList current = head;
        while(current.next != null)
            current = current.next;
        return current.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        if(head == null)
            return "[ ]";
        String res = "[ " + head.data;
        DoubleLinkedList current = head.next;
        while(current != null) {
            res += ", " + current.data;
            current = current.next;
        }
        res += " ]";
        return res;
    }
// ----------------------- Part 1 -----------------------
    public static LinkList cut(LinkList x) {
        if (x.head == null || x.head.next == null) {
            return x;
        }

        DoubleLinkedList first = x.head;
        DoubleLinkedList last = x.head;
        DoubleLinkedList prev = null;

        while (last != null && last.next != null) {
            prev = first;
            first = first.next;
            last = last.next.next;
        }


        prev.next = null;


        LinkList result = new LinkList();
        result.head = first;


        DoubleLinkedList temp = result.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = x.head;

        return result;
    }

    // ----------------------- Part 2 -----------------------
    public void cutList() {
        if (this.head == null || this.head.next == null) {
            return;
        }


        DoubleLinkedList first = this.head;
        DoubleLinkedList last = this.head;
        DoubleLinkedList prev = null;

        while (last != null && last.next != null) {
            prev = first;
            first = first.next;
            last = last.next.next;
        }


        prev.next = null;


        DoubleLinkedList temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = this.head;

        this.head = first;
    }
}