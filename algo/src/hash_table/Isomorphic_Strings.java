package hash_table;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        isIsomorphic("egg", "bar");
    }

    /**
     * 생각보다 쉽지 않은 문제였다.
     * 처음에 카운팅으로 계산해서 풀었는데 숫자는 동일하더라도 맞지 않는 문자열이 들어오는 문제가 있었다.
     * 그래서 양방향으로 해싱을해서 서로 같은 문자열이 되는지 판단하는 식으로 코드를 짯는데
     * 아무래도 내가 해싱을 하는 부분이 좀 부족한것같다 아이디어라던지 뭔가 논리가 부족한 듯 하다.
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash1 = new HashMap<>();
        Map<Character, Character> hash2 = new HashMap<>();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if(!hash1.containsKey(arr1[i])) {
                hash1.put(arr1[i], arr2[i]);
            }
            if(!hash2.containsKey(arr2[i])) {
                hash2.put(arr2[i], arr1[i]);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        for(Character c : s.toCharArray()) {
            sb1.append(hash1.get(c));
        }
        StringBuilder sb2 = new StringBuilder();
        for(Character c : t.toCharArray()) {
            sb2.append(hash2.get(c));
        }
        return t.contentEquals(sb1) && s.contentEquals(sb2);
    }

    /**
     * 먼저 넣고 판단하는게 아니라 넣으면서 판단이 가능하다.
     * 네이밍도 st 이런식으로 s 에서 t로 해싱한다 이런 식으로 직관적으로 네이밍 하는게 좋다.
     */
    public static boolean __isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // s -> t 매핑이 이미 존재할 때 불일치 확인
            if (mapST.containsKey(c1)) {
                // c2 가 다른놈이라면 변경이 불가하니 바로 false
                if (mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            // t -> s 매핑도 동시에 확인
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }
}
