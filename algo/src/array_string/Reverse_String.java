package array_string;

public class Reverse_String {
    public static void main(String[] args) {

    }

    // 이문제는 사실 투포인터로 풀어도 문제 없다.
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}
