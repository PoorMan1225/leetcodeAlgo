package binary_search;

public class Guess_Number_Higher_or_Lower {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int r = guess((int)mid);
            if (r == 0) return (int) mid;
            else if (r == -1) {
                right = mid - 1;
            } else if (r == 1) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
