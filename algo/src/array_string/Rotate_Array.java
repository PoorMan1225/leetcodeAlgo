package array_string;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
//        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        __rotate(new int[]{1, 2, 3, 4}, 2);
    }

    /**
     * 문제설명
     * 정수 배열이 주어졌을때 배열을 k 만큼 오른쪽으로 이동한다.
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     * <p>
     * 추가 메모리를 사용해서 구현
     */
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 이부분은 모듈러 연산으로 역함수를 구할 수 있다. 자세한 내용은 md 파일 참조
            int newIndex = (i + k) % nums.length;
            result[newIndex] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    // 추가 메모리를 사용하지 않고 구현.
    // 여기서 중요한 포인트는 오른쪽으로 세번의 회전을 하기 위해서는
    // 뒤의 세개의 요소를 앞으로 가져오고 나머지 요소를 뒤에 배치하는 것이다.
    // ex [1,2,3,4,5,6,7] => [5,6,7,1,2,3,4]

    // 이렇게 하기위해서는 다음과 같이 해야 한다.
    // 1. 첫번째로 모든 요소를 뒤집는다.
    // [7,6,5,4,3,2,1]
    // 2. 두번째로 이동할 k요소 여기서는 뒤의 k요소 를 뒤집는다.
    // [5,6,7,4,3,2,1]
    // 3. 마지막으로 나머지 k+1 ~ n 요소를 뒤집는다.
    // [5,6,7,1,2,3,4]

    // 왼쪽으로 k만큼 이동하는것도 비슷한 원리로 구현 가능하다.
    // ex [1,2,3,4,5,6,7] => [4,5,6,7,1,2,3]
    // 1. 첫번째로 모든 요소를 뒤집는다.
    // [7,6,5,4,3,2,1]
    // 2. 이동할 요소 뒤에서 k 번째 를 뒤집는다.
    // [7,6,5,4,1,2,3]
    // 3. 나머지 요소를 뒤집는다.
    // [4,5,6,7,1,2,3]
    public static void __rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverce(nums, 0, n - 1);
        reverce(nums, 0, k - 1);
        reverce(nums, k, n - 1);

    }

    public static void reverce(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
