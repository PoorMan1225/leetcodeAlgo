package recursion_1;

public class Fibonacci_Number {
    public static void main(String[] args) {
        final int result = fib(4);
        System.out.println("result = " + result);
    }

    /**
     * 중첩 계산을 하기 싫어서 반복으로 처리
     */
    public static int fib(int n) {
        int prev = 0;
        int next = 1;
        if(n < 2) return n;
        int result = 0;
        while(n >= 2) {
            result = prev + next;
            prev = next;
            next = result;
            n--;
        }
        return result;
    }
}
