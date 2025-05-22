package array_string;

public class Implement_strStr {
    public static void main(String[] args) {
        final int i = strStr("mississippi", "sipp");
        System.out.println("i = " + i);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int left = 0;
        int right = needle.length() - 1;
        while (right < haystack.length()) {
            if (haystack.charAt(left) == needle.charAt(0) && haystack.charAt(right) == needle.charAt(needle.length() - 1)) {
                int _left = left;
                int index = 0;
                while (_left <= right) {
                    if (needle.charAt(index) != haystack.charAt(_left)) {
                        break;
                    }
                    _left++;
                    index++;
                }
                if (index == needle.length()) return left;
            }
            right++;
            left++;
        }
        return -1;
    }

    public static int isSame(String haystack, String needle, int i, int j) {
        int n1 = haystack.length();
        int n2 = needle.length();
        int idx = i;
        while (i < n1 && j < n2) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return -1;
            }
            i++;
            j++;
        }
        return (j == n2) ? idx : -1;
    }

    /**
     * 변수가 너무 많아지고 외부 함수가 필요한 경우 함수사용을 적극적으로 해보자.
     * 함수로 분리 하지 않으면 변수가 많아져서 머리속이 복잡해질 수 있다.
     */
    public int __strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        int i = 0;
        int j = 0;
        int result = -1;
        while (i < n1) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                result = isSame(haystack, needle, i, j);
                if (result != -1) return result;
                i++;
            } else {
                i++;
            }
        }
        return result;
    }


}
