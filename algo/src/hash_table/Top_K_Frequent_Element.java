package hash_table;

import java.util.*;

public class Top_K_Frequent_Element {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>(map.entrySet());
        result.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return result.stream()
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
