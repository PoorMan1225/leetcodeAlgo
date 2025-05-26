package array_string;

public class Reverse_Words_in_a_String_2 {
    public static void main(String[] args) {
        final String result = reverseWords("Let's take LeetCode contest");
        System.out.println("result = " + result);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        sb.reverse();
        String rs = sb.toString();
        String[] split = rs.split(" ");
        for(int i=split.length-1; i>=0; i--) {
            result.append(split[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * StringBuilder 도 String 처럼 사용 하면된다.
     */
    public String __reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }
}
