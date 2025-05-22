package array_string;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        final String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println("s = " + s);
    }

    /**
     * 문제설명
     * 배열이 주어지면 가장 긴 접두사를 찾는 문제다 없으면 공백을 리턴한다.
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
