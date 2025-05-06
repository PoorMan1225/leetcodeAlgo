package array;

import java.util.Arrays;

// 제곱으로 이루어진 정렬된 배열
public class Sqaures_of_a_Sorted_Array {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        final int[] sortedArray = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sortedArray[i] = nums[i] * nums[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
