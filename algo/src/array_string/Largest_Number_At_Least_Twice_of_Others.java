package array_string;

import java.util.Arrays;

public class Largest_Number_At_Least_Twice_of_Others {
    public static void main(String[] args) {
        dominantIndex(new int[]{3, 6, 1, 0});
    }

    /**
     * 문제설명
     * 배열에서 가장 큰 요소가 배열의 다른 모든 숫자보다 최소 두배 이상 큰지 확인한다.
     * 두배 이상 큰 경우 가장 큰 요소의 인덱스를 반환하고 그렇지 않은경우 -1 을 리턴한다.
     */
    public static int dominantIndex(int[] nums) {
        int maxValue = 0;
        int secondValue = 0;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxValue) {
                maxIndex = i;
                secondValue = maxValue;
                maxValue = nums[i];
            } else if (nums[i] < maxValue && nums[i] >= secondValue) {
                secondValue = nums[i];
            }
        }
        return maxValue >= secondValue * 2 ? maxIndex : -1;
    }

    /**
     * 먼저 인덱스를 찾고 그 인덱스가 아니면 비교하는 방법도 유효하다.
     */
    public int __dominantIndex(int[] nums) {
        int max = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != idx) {
                if (max < (nums[i] * 2)) {
                    return -1;
                }
            }
        }
        return idx;
    }
}
