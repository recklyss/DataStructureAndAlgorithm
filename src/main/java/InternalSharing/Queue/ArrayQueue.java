package InternalSharing.Queue;

public class ArrayQueue {

    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int initialSize) {
        array = new int[initialSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full!");
        }
        if (rear == array.length - 1) {
            System.out.println("Adjusting queue.");
            int[] newArray = new int[this.array.length];
            System.arraycopy(array, front, newArray, 0, rear - front + 1);
            this.array = newArray;
            rear = rear - front;
            front = 0;
        }
        rear++;
        array[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        front++;
        size--;
        return array[front - 1];
    }

    public int peek() {
        if (front == rear + 1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void print() {
        System.out.println("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.print();
        System.out.println("Dequeue: " + queue.dequeue());
        queue.print();
        System.out.println("Peek: " + queue.peek());
        queue.print();
        System.out.println("Size: " + queue.size());
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println("Is Full: " + queue.isFull());
        queue.enqueue(7);
        queue.print();
    }
}
