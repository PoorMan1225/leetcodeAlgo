package hash_table;

import java.util.*;

public class Contains_Duplicate_2 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() <= 1) continue;
            for (int i = 1; i < list.size(); i++) {
                if (Math.abs(list.get(i) - list.get(i - 1)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 인덱스 갱신으로 푸는 방식
     * 어차피 들어온 순서대로니까 인덱스는 무조건 정렬이 되어 있기 때문에 갱신 비교 갱신 하면 된다.
     */
    public boolean _containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                int nextIndex = i;
                if (Math.abs(nextIndex - prevIndex) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i); // 최초 인덱스 넣기.
        }
        return false;
    }

    /**
     * Set 을 통한 거리계산 방식
     * 예를들어 k=3 이라면 최대거리를 3이라고 보고 k 거리 이내에 중복된 값이 존재할 경우
     * true 를 반환하는 방식이다.
     */
    public boolean __containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 먼저 넣어보고 안넣어지면 중복
            if (!set.add(nums[i])) return true;
            if (set.size() > k) {
                set.remove(nums[i - k]); // k 개를 유지하는 방법.
            }
        }
        return false;
    }
}
