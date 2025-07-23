package recursion_1;

public class Pow {
    public static void main(String[] args) {
        final double v = myPow(0.44528, 0);
        System.out.println(v);
    }

    // 아 long 으로 안바꾸면 스택 오버플로가 발생할 수 있다.
    // 왜냐하면 int 일때 -213... 범위를 벗어나면 양수범위로 반환되기때문에 발생할 수 있다.
    public static double myPow(double x, int n) {
        long N = n;  // int -> long 변환
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;
    }
}
