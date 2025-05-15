package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_All_Numbers_Disappared_in_an_Array {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    /**
     * 문제설명
     * 배열이 주어지고 범위에 있는 정수 중에 나타나지 않는 모든 정수의 배열을 반환한다.
     * input [4,3,2,7,8,2,3,1]
     * output [5,6]
     *
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            // 음수 인덱스가 들어올 수 있기 때문에 절대값 처리
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                // 이숫자는 체킹했다고 마킹용 음수 처리
                nums[index] = -nums[index];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i + 1); // 인덱스 + 1이 누락된 숫자
            }
        }
        return list;
    }
}
