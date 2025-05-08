package array;

import java.util.Arrays;

public class Remove_DUplicates_from_Sorted_Array {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,1,2});
    }

    // 문제 정의
    // 숫자 배열이 내림차순으로 정렬 되면 같은 숫자가 없도록
    // 들어온 숫자배열의 중복을 제거하고
    // 숫자개수 를 리턴.
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=0; i<nums.length;) {
            while(i < nums.length && nums[index] == nums[i]) {
                i++;
            }
            if (i >= nums.length) break;
            index = index + 1;
            nums[index] = nums[i];
        }
        return index+1;
    }

    // while 문으로 다음값을 계속 체크하지 않고.
    // 약간 dp 식으로 이전값이 변경 되었으면 변경되었다고 가정한 값을 가지고
    // 다음을 예상하는 식으로 체크한다.
    public static int removeDuplicates_(int[] nums) {
        int n = nums.length - 1;
        int start = 1;
        for(int i=1; i<n; i++) {
            // 이전값을 같도록 변경 함으로 써 다음에 체크할때도
            // 무조건 같은 값이 되니까 이전에 값만 변경해도 된다.
            if(nums[i-1] != nums[i]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }
}
