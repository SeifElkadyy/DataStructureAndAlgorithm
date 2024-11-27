package DataStructure.LinkedLists_1;

public class Link {
    public Object data;
    public Link next;

    public Link(Object o) {
        this.data = o;
        this.next = null;
    }

    public String toString() {
        return data.toString();
    }
}
