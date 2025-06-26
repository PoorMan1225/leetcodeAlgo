package hash_table;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
    }

    public int lengthOfLongestSubstring(String s) {
        char[] storage = new char[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                while (index >= 0 && storage[index] != '\u0000') {
                    map.remove(storage[index]);
                    storage[index] = '\u0000';
                    index--;
                    count--;
                }
            }
            count++;
            storage[i] = s.charAt(i);
            map.put(storage[i], i);
            max = Math.max(count, max);
        }
        return max;
    }

    /**
     * 연속적인 문자가 보인다면 슬라이딩 윈도우를 활욯해보자.
     */
    public int __lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 중복 문자라면, left를 점프
            if (map.containsKey(c)) {
                // 이전 위치보다 left가 앞일 경우만 업데이트
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // 현재 문자 위치 갱신
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
