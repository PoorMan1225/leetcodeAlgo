package recursion_1;

public class Reverse_String {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        reverseString(s, 0);
    }

    public void reverseString(char[] s, int start) {
        if(start < s.length / 2) return;
        char tmp = s[start];
        s[start] = s[s.length - 1 - start];
        s[s.length - 1 - start] = tmp;
        reverseString(s, start + 1);
    }
}
