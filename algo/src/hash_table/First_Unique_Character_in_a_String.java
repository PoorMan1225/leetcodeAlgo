package hash_table;

import java.util.HashMap;

public class First_Unique_Character_in_a_String {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        char st[] = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : st) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < st.length; i++) {
            if (map.get(st[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int __firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
