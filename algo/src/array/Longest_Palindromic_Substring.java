package array;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String result = longestPalindrome("cbbd");
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        String result = "";

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            int len = right - left + 1;

            // 이미 찾은 결과가 현재 구간보다 길면 더 볼 필요 없음
            if (result.length() >= len) break;

            // 1. 왼쪽 고정, 오른쪽 줄이기 (긴 것부터 검사)
            for (int i = left; i <= right; i++) {
                if (isPalindrome(chars, i, right)) {
                    String palindrome = s.substring(i, right + 1);
                    if (result.length() < palindrome.length()) {
                        result = palindrome;
                    }
                    break; // 긴 것부터 검사하니까 첫 번째가 최장
                }
            }

            // 2. 오른쪽 고정, 왼쪽 늘리기 (긴 것부터 검사)
            for (int j = right; j >= left; j--) {
                if (isPalindrome(chars, left, j)) {
                    String palindrome = s.substring(left, j + 1);
                    if (result.length() < palindrome.length()) {
                        result = palindrome;
                    }
                    break; // 마찬가지로 첫 번째가 최장
                }
            }

            left++;
            right--;
        }

        return result;
    }

    public static boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    // 값을 하나 찾고 중간에 갑이 있는 패턴인지 아닌지 체크
    public static String _longestPalindrome(String s) {
        // 하나의 값씩 찾는다.
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // 그 값이 홀수개의 팰린드롬인지 짝수개의 팰린드롬인지 판단해서 길이 값을 가지고온다.
            // 해당 인덱스의 홀수 개의 팰린드롬의 최대값 의 길이를 가져오기
            int len1 = checkPalindromeEvenAndOdd(chars, i, i);
            // 해당 인덱스의 짝수 개의 팰린드롬의 최대값 의 길이를 가져오기
            int len2 = checkPalindromeEvenAndOdd(chars, i, i + 1);
            int len = Math.max(len1, len2);
            // 홀수 인지 짝수인지 판단한다.
            if(result.length() >= len) {
                continue;
            }
            // 이제 값을 갱신한다.
            int start;
            int end;
            if(len % 2 == 0) { // 짝수일때는 ex) 6 -> 6 / 2 -> 3 -1 해야 인덱스 기준 맞음
                start = (i - (len - 1) / 2);
                end = (i + len / 2);
            } else { // 홀 수 일때 ex) 5 라면 인덱스 기준이므로 5 - 1 / 2 해야 2씩 뒤로
                start = (i - (len - 1) / 2);
                end = (i + (len - 1) / 2);
            }
            result = s.substring(start, end + 1);
        }
        return result;
    }

    public static int checkPalindromeEvenAndOdd(char[] chars, int left, int right) {
        // 반복을 돌면서 팰린드롬인지 체크한다.
        // 왼쪽 좌표는 하나씩 감소해야 하고 0보다 크거나 같아야한다.
        // 오른쪽 좌표는 하나씩 증가해야 하고 배열의 길이보다 작아야 한다.
        while (left >= 0 && right < chars.length) {
            // 한개씩 비교해서 팰린드롬인지 찾는다.
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        // 길이값을 반환한다.
        return right - left + 1;
    }
}
