package array_string;

import java.util.Arrays;

public class Find_Pivot_Index {
    public static void main(String[] args) {
        final int result = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println("result = " + result);
    }

    /**
     * 문제설명
     * 특정 인덱스가 주어지고 그인덱스 기준으로 왼쪽 오른쪽의 합이 같아지면 pivot 인덱스라고 부른다.
     * pivot 인덱스를 리턴하고 존재하지 않으면 -1 을 리턴한다.
     */
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) sum += nums[i];
        for(int i=0; i<nums.length; i++) {
            sum -= nums[i];
            if(sum == leftSum) return i;
            else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
