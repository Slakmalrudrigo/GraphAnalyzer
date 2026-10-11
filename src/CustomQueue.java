package src;


public class CustomQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;
    private static final int DEFAULT_CAPACITY = 20;

    public CustomQueue() {
        this.queue = new int[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public void enqueue(int value) {
        if (count == queue.length) {
            // Expand queue
            int[] newQueue = new int[queue.length * 2];
            for (int i = 0; i < count; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            rear = count;
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        count++;
        System.out.println("Enqueued " + value + " to queue.");
    }


    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty! Cannot perform dequeue operation.");
            return null;
        }
        int dequeuedValue = queue[front];
        front = (front + 1) % queue.length;
        count--;
        System.out.println("Dequeued " + dequeuedValue + " from queue.");
        return dequeuedValue;
    }


    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty! Cannot perform peek operation.");
            return null;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty: []");
            return;
        }
        System.out.print("Queue elements (Front -> Rear) [" + count + "]: [");
        for (int i = 0; i < count; i++) {
            int val = queue[(front + i) % queue.length];
            System.out.print(val + (i < count - 1 ? " <- " : ""));
        }
        System.out.println("]");
    }

    public int getSize() {
        return count;
    }
}
