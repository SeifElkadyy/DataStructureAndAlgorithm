package Queue;

public class  ShiftZeros {
    public static void shiftZeroes(QueueObj queue) {
        int size = queue.size();
        int zeroCount = 0;

        for (int i = 0; i < size; i++) {
            Object element = queue.dequeue();
            if (element.equals(0)) {
                zeroCount++;
            } else {
                queue.enqueue(element);
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            queue.enqueue(0);
        }
    }

    public static void main(String[] args) {
        QueueObj q = new QueueObj(10);
        q.enqueue(5);
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(0);
        q.enqueue(0);
        q.enqueue(6);
        q.enqueue(1);
        q.enqueue(0);

        System.out.println("Before shifting zeroes:");
        q.printQueue();

        shiftZeroes(q);

        System.out.println("After shifting zeroes:");
        q.printQueue();
    }
}