package binary_search;

public class Pow {
    public static void main(String[] args) {

    }

    public static double myPow(double x, int n) {
        boolean isMinus = n < 0;
        long exp = Math.abs((long) n);

        double result = 1.0;
        double mul = x;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= mul;
            }
            mul *= mul;   // 제곱
            exp /= 2;
        }
        // 2^2 가 분수가되면 1 / 2^2 인데 착각했다..
        return isMinus ? 1.0 / result : result;
    }
}
