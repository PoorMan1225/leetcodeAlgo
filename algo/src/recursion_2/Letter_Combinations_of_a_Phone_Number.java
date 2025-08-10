package recursion_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        final List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        char[] chars = new char[digits.length()];

        dfs(0, map, digits, result, chars);
        return result;
    }

    public static void dfs(int level, Map<Character, List<Character>> map, String digits, List<String> result, char[] chars) {
        if (level == digits.length()) {
            result.add(new String(chars));
            return;
        }
        char key = digits.charAt(level);
        List<Character> characterList = map.get(key);
        for (char c : characterList) {
            chars[level] = c;
            dfs(level + 1, map, digits, result, chars);
        }
    }

    private static final String[] KEYS = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public static List<String> __letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        dfs(0, digits, new StringBuilder(), result);
        return result;
    }

    private static void dfs(int index, String digits, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            dfs(index + 1, digits, path, result);
            path.deleteCharAt(path.length() - 1); // backtracking
        }
    }
}
