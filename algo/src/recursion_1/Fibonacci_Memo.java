package recursion_1;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Memo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<>();

    }

    public static int fibo(Map<Integer, Integer> memo, int n) {
        // 해시맵을 선언해서 값을 메모한다.
        if(memo.containsKey(n)) return memo.get(n);
        // 값이 2보다 작다면 해당 값을 반환한다.
        int value;
        if(n < 2) {
            value = n;
        } else {
            value = fibo(memo, n - 1) + fibo(memo, n - 2);
        }
        // 값이 2보다 크다면 fibo - 1 + fibo - 2 를 더한 값을 반환한다.
        // 그리고 그 결과를 메모에 저장하낟.
        memo.put(n, value);
        return value;
    }
}
