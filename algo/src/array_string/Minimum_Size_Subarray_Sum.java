package array_string;

import java.util.Arrays;

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        final int result = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println("result = " + result);
    }

    /**
     * 배열에 들어오는 원소들의 구간합이 target 과 일치하는 최소 갯수를 반환하는 문제
     * 정석적인 slidig window 문제로 window 의 구간을 right - left + 1 로 구한다.
     * 여기서 포인트는 구간의 합을 계산할때 left 를 줄이면서 계산한다는 것
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                int windowLength = right - left + 1;
                result = Math.min(result, windowLength);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
