package binary_search;

import java.util.*;

public class Intersection_of_Two_Arrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) set1.add(n);
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) set2.add(n);

        List<Integer> list1 = new ArrayList<>(set1);
        Collections.sort(list1);
        List<Integer> list2 = new ArrayList<>(set2);
        Collections.sort(list2);

        List<Integer> result = new ArrayList<>();
        for (Integer n : list2.size() > list1.size() ? list1 : list2) {
            int left = 0;
            int right = list2.size() > list1.size() ? list2.size() - 1 : list1.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list1.get(mid) > n) {
                    right = mid - 1;
                } else if (list1.get(mid).equals(n)) {
                    result.add(n);
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
