package binary_search_tree;

import java.util.*;

public class Contains_Duplicate_3 {
    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0);
    }

    // 슬라이딩 윈도우 + 절대값 계산 + Treeset 자료구조 활용
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];
            // curr - valueDiff 보다 크거나 같지만 가장 작은 값을 가지고 온다.
            Long value = set.ceiling(curr - (long) t);
                 // |nums[i] - nums[j]| ≤ t
            //이걸 변형하면:
                 //nums[i] - t ≤ nums[j] ≤ nums[i] + t
            //우리가 지금 찾고 있는 건:
                 //curr - t ≤ value ≤ curr + t
            if(value != null && value <= t + curr) {
                return true;
            }
            // 조건을 만족하지 않는 다면 set 에 범위에 추가.
            set.add(curr);
            // (2) 윈도우 사이즈 유지 (i - k 위치 값 제거)
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
