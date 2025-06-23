package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_2 {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // 데이터를 저장할 map 을 선언한다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                if (map.get(n) == 1) {
                    map.remove(n);
                } else {
                    map.put(n, map.get(n) - 1);
                }
                result.add(n);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
