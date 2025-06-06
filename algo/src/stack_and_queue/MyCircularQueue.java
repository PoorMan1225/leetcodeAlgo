package stack_and_queue;

public class MyCircularQueue {
    private int head;
    private int tail;
    private int[] arr;
    private int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /**
     * 최초 값을 넣을때 size 변수가 없으면 넣어야 하는건지 아니면 다차서 들어갈 수 없는건지 판단이 안된다.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[tail % arr.length] = value;
        tail = (tail + 1) % arr.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        arr[head % arr.length] = 0;
        head = (head + 1) % arr.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[head % arr.length];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(tail - 1 + arr.length) % arr.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
