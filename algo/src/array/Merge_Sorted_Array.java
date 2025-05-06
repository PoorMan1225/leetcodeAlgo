package array;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    // 앞에서 부터 배열을 복사하는 식으로 풀었다.
    // 하지만 이문제 같은 경우는 뒤에서 부터 값을 복사하는 방법으로 푸는게 더 효과적이다.
    // 왜냐하면 앞에서 부터 복사하는 방법으로 수행하면 값이 뒤틀릴 수 있기 때문에 어차피 i < m 이므로
    // m-1 위치에서 부터 값을 비교해서 뒤에서부터 넣는 방식으로 수행하는게 더 적합하다.
    // 뒤에서부터 값을 찾아서 넣게 되면 불필요한 배열의 복사가 사라지게 된다.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = nums1.clone();
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            while(i < m && copy[i] <= nums2[j]) {
                nums1[k++] = copy[i++];
            }
            while(j < n && nums2[j] < copy[i]) {
                nums1[k++] = nums2[j++];
            }
        }
        while(i < m) {
            nums1[k++] = copy[i++];
        }
        while(j < n) {
            nums1[k++] = nums2[j++];
        }
    }

    public static void merge2(int[] nums1, int m , int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--; k--;
            }else {
                nums1[k] = nums2[j];
                j--; k--;
            }
        }
        // 남은 nums2 요소 복사 (nums1은 이미 그 자리에 있음)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
