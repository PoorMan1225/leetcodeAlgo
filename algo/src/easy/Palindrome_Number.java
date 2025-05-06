package easy;

public class Palindrome_Number {
    public static void main(String[] args) {
        isPalindromeV2(121);
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String value = String.valueOf(x);
        for(int i=0; i<value.length() / 2; i++) {
            if(value.charAt(i) != value.charAt(value.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        // rev 이 x 즉 절반 보다 더 커지지 않을때까지 반복을 진행한다.
        while (x > rev) {
            // 맨 끝의 값을 가지고 온다.
            rev = rev * 10 + x % 10;
            System.out.println("rev = " + rev);
            // 맨끝 값을 제외한 나머지 값을 가지고 온다.
            x = x / 10;
            System.out.println("x = " + x);
        }
        // x 와 rev 이 같게 되면 정답이고
        // 숫자의 길이가 홀수 인 경우에는 ex) 121 -> 12, 1 이렇게 되므로 rev 에 10을 나눠서 비교한다.
        return (x == rev || x == rev / 10);
    }
}
