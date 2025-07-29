package recursion_2;

import java.util.Arrays;

public class Sort_an_Array {
    public static void main(String[] args) {
        final int[] ints = sortArray(new int[]{7, 1, 3, 5, 6, 9, 8, 7});
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int pivot = nums.length / 2;
        int[] leftArray = sortArray(Arrays.copyOfRange(nums, 0, pivot));       // 인덱스 포함 ~ 인덱스 미포함
        int[] rightArray = sortArray(Arrays.copyOfRange(nums, pivot, nums.length)); // 인덱스 포함 ~ 인덱스 미포함
        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        int[] copied = new int[leftArray.length + rightArray.length];
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                copied[mergeIndex++] = leftArray[leftIndex++];
            } else {
                copied[mergeIndex++] = rightArray[rightIndex++];
            }
        }
        while (leftIndex < leftArray.length) {
            copied[mergeIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            copied[mergeIndex++] = rightArray[rightIndex++];
        }
        return copied;
    }

    /**
     * copy back 하는 방법
     * temp 를 만들어서 넘김으로써 공간을 많이 차지 않게 되고 공간 복사 비용이 사라지게 된다.
     */
    public static int[] __sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);
        merge(nums, temp, left, mid, right);
    }

    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // copy back
        if (right + 1 - left >= 0) System.arraycopy(temp, left, nums, left, right + 1 - left);
    }
}
