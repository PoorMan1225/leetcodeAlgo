package binary_search;

public class Valid_Perfect_Square {
    public static void main(String[] args) {

    }

    public boolean isPerfectSquare(int num) {
        // 먼저 left , right 변수 선언한다.
        int left = 1; // left 는 1부터 가야한다.
        int right = num;
        // 반복문을 돌면서 제곱을 했을때의 최소 값을 찾아야 한다.
        // left, right 가 같은 포인터를 바라봐야 한다.
        while(left < right) {
            int mid = left + (right - left) / 2;
            // 제곱이 num 보다 크다면
            // right 가 넘어와야 하니까
            if(mid < (num / mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // num 보다 크거나 작다면 제곱이 될 수 없다.
        return (left * left) == num;
    }
}
