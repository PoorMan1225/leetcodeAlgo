package array;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        final int[] result = sortedSquares(new int[]{-7,-3,2,3,11});
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    /**
     * 문제설명
     * 오름차순으로 정렬된 정수 배열이 주어지면, 각 숫자의 제곱이 오름차순이 되는 배열을 반환한다.
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 내림차순이 아닌 순서 로 정렬됩니다 .
     * <p>
     * 투포인터로 o(n) 으로 바꿔보자.
     */
    public static int[] sortedSquares(int[] nums) {
        // 투포인터 를 먼저 선언한다.
        int right = nums.length - 1;
        int left = 0;
        // result 를 담을 배열을 만들어서 인덱스를 감소시키면서 배열에 채운다.
        int index = nums.length - 1;
        int[] result = new int[nums.length];

        // 마지막 값도 비교해서 넣어야 하기 때문에 left <= right 로 되어야 한다.
        while (left <= right) {
            if(index < 0) return result;
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result[index] = nums[right] * nums[right];
                right--;
            } else {
                result[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return result;
    }
}
