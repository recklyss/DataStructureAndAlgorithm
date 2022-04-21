package InternalSharing.Queue;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedQueue {

    private Node front;

    private Node rear;

    public LinkedQueue(int... numbers) {
        if (numbers.length == 0) {
            this.front = null;
            this.rear = null;
            return;
        }
        this.front = this.rear = new Node(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            this.rear.next = new Node(numbers[i]);
            this.rear = this.rear.next;
        }
    }

    public void enqueue(int i) {
        if (isEmpty()) {
            this.front = this.rear = new Node(i);
            return;
        }
        this.rear.next = new Node(i);
        this.rear = this.rear.next;
    }

    public boolean isEmpty() {
        return front == rear && rear == null;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            throw new RuntimeException("Queue is empty!");
        }
        Node tmp = this.front;
        this.front = this.front.next;
        tmp.next = null;
        return tmp.val;
    }

    public int peek() {
        return this.front.val;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node index = this.front;
        while (index != null) {
            System.out.print(index.val + " -> ");
            index = index.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue(3, 4, 6, 1, 7, 8);
        linkedQueue.print();
        linkedQueue.enqueue(9);
        linkedQueue.enqueue(2);
        linkedQueue.print();
        System.out.println("linkedQueue.dequeue() = " + linkedQueue.dequeue());
        System.out.println("linkedQueue.peek() = " + linkedQueue.peek());
        linkedQueue.print();
    }
}
