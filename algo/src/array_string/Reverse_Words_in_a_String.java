package array_string;

import java.util.Arrays;

public class Reverse_Words_in_a_String {
    public static void main(String[] args) {
        final String s = reverseWords("a good   example");
        System.out.println("s = " + s);
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                res.append(words[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

    /**
     * 재귀호출 방식 코드 시간복잡도 o(n + k) (k : 재귀의 depth)
     * index 를 반환하므로 인덱스 까지의 new String(arr, 0 , index) 을 생성하는 코드도 필요.
     */
    public int reversewordslength(char[] st, char[] arr, int start) {
        while (start < st.length && st[start] == ' ') {
            start++;
        }
        int end = start;
        while (end < st.length && st[end] != ' ') {
            end++;
        }
        if (start - end == 0) {
            return 0;
        }
        int reversedwordlen = reversewordslength(st, arr, end);
        if (reversedwordlen != 0) {
            arr[reversedwordlen] = ' ';
            reversedwordlen++;
        }
        while (start < end) {
            arr[reversedwordlen++] = st[start++];
        }
        return reversedwordlen;
    }
}
