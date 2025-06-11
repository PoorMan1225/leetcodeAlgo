package stack_and_queue;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    /**
     * 폴란드식 표현법으로 계산 하는 문제인데
     * 스택에 넣고 계산한 결과를 다시 스택에 넣는 식으로 풀 수 있다.
     * 근데 스택 자체를 정수로 바꾸는게 나을듯
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            // 이렇게 operator 가 많으면 이걸 set 로 묶던지 할 수 도 있다.
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            int v1 = stack.pop();
            int v2 = stack.pop();
            switch (s) {
                case "+" -> stack.push(v2 + v1);
                case "-" -> stack.push(v2 - v1);
                case "*" -> stack.push(v2 * v1);
                default -> stack.push(v2 / v1);
            }
        }
        return stack.pop();
    }
}
