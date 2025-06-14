package stack_and_queue;

import java.util.Stack;

public class Decode_String {
    public static void main(String[] args) {
        final String result = decodeString("10[leetcode]");
        System.out.println("result = " + result);
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push("]");
                continue;
            }
            if (s.charAt(i) == ']') {
                StringBuilder offset = new StringBuilder();
                while (!stack.peek().equals("]")) {
                    offset.insert(0, stack.pop());
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(offset.toString());
                    continue;
                }
                StringBuilder count = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    count.insert(0, stack.pop());
                }
                int value = Integer.parseInt(count.toString());
                // repeat 함수로 간단하게 개선 할 수 있다.
                stack.push(offset.toString().repeat(value));
                continue;
            }
            stack.push(String.valueOf(s.charAt(i)));
        }
        StringBuilder result = new StringBuilder();
        for (String value : stack) {
            result.append(value);
        }
        return result.toString();
    }
}
