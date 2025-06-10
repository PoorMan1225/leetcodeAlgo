package stack_and_queue;

import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {

    }

    /**
     * 그냥 단순하게 닫는 괄호가 왔을때 들어온 괄호랑 같은지 체크하는 식으로 플었다.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || !(c == ')' || c == '}' || c == ']')) {
                stack.push(c);
                continue;
            }
            if(c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 들어온 괄호를 넣는게 아니고 닫는괄호를 오히려 반대로 넣은 후에
     * 닫는 괄호를 만났을때 하나씩 pop 하면서 체크
     * 이렇게하면 스택이 비었을때도 바로 push 할 수 있게 된다.
     */
    public boolean _isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // 오른쪽 괄호가 더많이 들어왔을경우 stack 이 이미 비어 있을 수 있다.
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        // 왼쪽 괄호가 더많이 들어왔을 경우 스택에 값이 있을 수 있다.
        return stack.isEmpty();
    }
}
