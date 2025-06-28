package binary_search;

public class Sqrt {
    public static void main(String[] args) {
        mySqrt(2147395599);
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1;
        long right = x;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid == x / mid) { // 오버플로 방지
                return (int) mid;
            } else if(mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right; // right 가 마지막 값이 된다. 왜냐하면 큰쪽에서 마지막 left > right 가 되는 시점의 값이 되므로
    }
}
