package array;

import java.util.Arrays;

public class Sort_Array_By_Parity {
    public static void main(String[] args) {
        final int[] ints = sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 문제 설명
     * 정수 배열이 주어졌을때 짝수 정수를 먼저 옮긴 후 홀수 정수를 옮긴뒤
     * 배열을 리턴 한다.
     * <p>
     * 짝수인 경우를 앞으로 모두 가져오면 나머지는 홀수가 될 것이다.
     */
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        for (left = 0; left < nums.length; left++) {
            if (nums[left] % 2 != 0) break;
        }
        if (left >= nums.length) return nums;
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[left] % 2 != 0 && nums[i] % 2 == 0) {
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            }
        }
        return nums;
    }

    /**
     * 두개의 포인터를 사용하는 경우 이방법을 사용하는게 직관적이다.
     */
    public int[] _sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for (int num : nums) {
            // 짝수의 경우 처음부터 처음 부터 배열을 채운다.
            if (num % 2 == 0) {
                result[left++] = num;
                // 홀 수의 경우 뒤에서 부터 배열을 채운다.
            } else {
                result[right--] = num;
            }
        }
        return result;
    }
}
