package InternalSharing.ListSharing;

class Node {
    public int val;
    public Node next;

    public Node(int x) {
        val = x;
    }
}

public class List {
    private Node head;

    public void of(int... nums) {
        this.head = new Node(nums[0]);
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
    }

    public void print() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void deleteHead() {
        Node tmp = this.head;
        this.head = this.head.next;
        tmp.next = null;
    }

    public static void main(String[] args) {
        var list = new List();
        list.of(3, 4, 6, 8, 9);
        list.print();
        list.deleteHead();
        list.print();
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
