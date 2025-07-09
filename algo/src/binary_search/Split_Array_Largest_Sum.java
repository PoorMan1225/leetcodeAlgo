package binary_search;

import java.util.Arrays;

public class Split_Array_Largest_Sum {
    public static void main(String[] args) {
    }

    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);         // 최소 가능한 최대 구간합
        int right = getSum(nums);        // 최대 가능한 최대 구간합

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 현재 mid를 최대 구간합으로 했을 때 m개 이하로 나눌 수 있는지
    private boolean canSplit(int[] nums, int m, int maxAllowedSum) {
        int count = 1; // 시작은 하나의 subarray
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                count++;
                currentSum = num;
                if (count > m) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
