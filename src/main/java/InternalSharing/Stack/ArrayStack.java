package InternalSharing.Stack;

public class ArrayStack {

    private final int[] array = new int[100];

    private int stackIndex = -1;

    public ArrayStack(int ... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            array[i] = numbers[i];
        }
        stackIndex = numbers.length - 1;
    }

    public void push(int val) {

    }

    public int pop() {
        return 0;
    }
}
