package stack_and_queue;

import java.util.Stack;

/**
 * 한컴에 물이 담겨있는데 그 윗부분을 제거해야 한다면
 * 다시 옮겨 담고 제거하는 식으로 구현해야 한다.
 * 물을 옮겨 담는 식으로 구현해야 한다.
 */
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
       // push 를 할때는 그냥 push 를 하면된다 우리는 peek 와 pop 만 생각해야 한다.
        pushStack.push(x);
    }

    public int pop() {
        // 1. 둘다 빈 경우는 배제한다.
        if (empty()) return -1;
        // 2. pop 스택이 비어있는지 확인한다.
        stackCopyToPush();
        return popStack.pop();
    }

    private void stackCopyToPush() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    public int peek() {
        // 1. 둘다 빈 경우는 배제한다.
        if (empty()) return -1;
        // 2. pop 스택이 비어있는지 확인한다.
        stackCopyToPush();
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
