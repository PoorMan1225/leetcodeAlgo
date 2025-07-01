package binary_search;

public class Search_for_a_Range {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;

        // 1. 첫 번째 발생 위치 (lower bound)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) return new int[]{-1, -1};
        int start = left;

        // 2. 마지막 발생 위치 (upper bound)
        left = 0;
        right = nums.length - 1;

        while (left < right) {
            // left + right / 2 가 계속 같은 값을 가리키기 때문에 무한루프 방지
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        int end = right;

        return new int[]{start, end};
    }


    /**
     * 더 직관적인 방법
     * 이진 탐색은 왜자꾸 그려도 뭔가 잘 안잡히는 부분이 있는것 같다.
     */
    public int[] __searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;  // continue searching in left part
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;  // continue searching in right part
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
