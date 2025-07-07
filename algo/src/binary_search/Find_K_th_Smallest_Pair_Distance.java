package binary_search;

import java.util.*;

public class Find_K_th_Smallest_Pair_Distance {
    public static void main(String[] args) {
    }

    /**
     * 파라메트릭 서치 방식.
     * 인덱스에 관심을 두는 것이 아니라 거리 자체에 두거나 다른 기준을 잡아서 이진 탐색을 하는 방식
     * 여기서는 거리가 기준이 된다. 직관적으로 생각하기 어려운 방식임. 연습필요.
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            int j = 0;

            // 투포인터를 사용해서 O(N2) 을 O(N) 으로 변경
            // i 가 n 번 만큼 증가하지만 j도 n 번만큼 증가하므로 시간복잡도는 2n 이 된다.
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) j++;
                // 같은 포인터 부터 빼줘야 조건이 안맞는 경우 0카운트가 됨
                // 어차피 같은 숫자는 무조건 차이의 최소값 0 보다 작을 것이므로 처음 j 는 무조건 한번 증가하고 시작함.
                count += j - i - 1;
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
