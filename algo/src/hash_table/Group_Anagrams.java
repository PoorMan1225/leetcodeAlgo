package hash_table;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Group_Anagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            // map key 가 없으면 계산된 식을 리턴한다.
            // 여기서 계산된 식이라는 건 List<String> 을 의미한다.
            map.computeIfAbsent(tmp, s1 -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
