package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;


public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        // 이부분이 굉장히 중요한 포인트!
        // 새로 들어온 값을 맨 앞에 오도록 회전
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return empty() ? -1 : queue.poll();
    }

    public int top() {
        return empty() ? -1 : queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
