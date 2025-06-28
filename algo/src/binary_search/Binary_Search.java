package binary_search;

public class Binary_Search {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 값 오버플로 방지 (left , right 는 오버플로가 아닌데 left + right 가 오버플로라면 이렇게 방지할 수 잇다.
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
