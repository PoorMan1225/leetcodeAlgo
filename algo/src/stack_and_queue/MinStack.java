package stack_and_queue;

import java.util.Stack;

/**
 * 최소 스택을 가지고 오는 문제
 * 스택은 기본적으로 LIFO 구조 이기 때문에 최소 스택을 계속 유지할 수 있다.
 */
public class MinStack {
    private Stack<Integer> original;
    private Stack<Integer> min;

    public MinStack() {
        original = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
        original.push(val);
    }

    public void pop() {
        if(original.isEmpty()) return;
        int value = original.pop();
        // 자바에서 객체 타입은 equals 로 비교해야 한다.
        // 여기서는 기본 타입과 비교 하기 때문에 괜찮다. Integer 끼리 비교할땐 equals 로 해야 한다.
        if(min.peek() == value) {
            min.pop();
        }
    }

    public int top() {
        if(original.isEmpty()) return -1;
        return original.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}
