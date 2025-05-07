package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Remove_Element {
    public static void main(String[] args) {

    }

    // 문제설명
    // 배열이 들어오고 어떤 특정 값이 주어지면 해당 배열에
    // 특정값을 제거하고 남은 개수를 리턴 한다.
    // 제거한 값을 제외한 나머지 값은 배열의 앞에 위치해야 한다.

    // 문제접근
    // 일단 특정값이랑 다른 경우 최대값을 넘은 값을 넣고
    // 정렬하여서 리턴했다.

    // 정렬을 하게 되었으므로 o(nlogn) 시간복잡도가 걸린다.
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == val) nums[i] = 51;
            else count++;
        }
        Arrays.sort(nums);
        return count;
    }

    // 더좋은 방법.
    // 특정값을 찾아서 값을 변경하는게 아니라 특정값이 아닐때만
    // 앞에서 부터 채워넣는 방식으로 사고를 전환해야 한다.
    public int removeElement_(int[] nums, int val) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
           if(nums[i] != val) {
               nums[count] = nums[i];
               count++;
           }
        }
        return count;
    }
}
