package binary_search;

public class Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

    }


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[right] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
