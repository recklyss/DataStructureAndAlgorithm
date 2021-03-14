package Alogrithm.Alogrithm.DesignHashMap;

public class MyHashMap {
    private static final int DEFAULT_BUCKET_SIZE = 8;
    private Node[] bucket;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this(DEFAULT_BUCKET_SIZE);
    }

    public MyHashMap(int bucketSize) {
        bucket = new Node[bucketSize];
    }

    private int hashIndex(int key) {
        return key % bucket.length;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hashIndex(key);
        Node head = bucket[index];
        Node node = head;
        while(node != null){
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        node = new Node(key, value);
        node.next = head;
        bucket[index] = node;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hashIndex(key);
        Node node = bucket[index];
        while (node != null){
            if (node.key==key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hashIndex(key);
        Node node = bucket[index];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            bucket[index] = node.next;
            return;
        }
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    static class Node {
        private int val;
        private int key;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
}
