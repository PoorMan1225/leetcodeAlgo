package binary_search;

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        __search(new int[]{4,5,6,7,8,9,0,1,2}, 0);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int pivot = findPivot(nums);

        // target 이 어느 쪽 정렬된 배열에 있는지 판단
        if (nums[pivot] <= target && target <= nums[n - 1]) {
            return binarySearch(nums, pivot, n - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    // 피벗 찾기: 배열에서 최솟값의 인덱스를 찾음
    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;  // 피벗은 오른쪽에 있음
            } else {
                right = mid;     // 피벗은 왼쪽 (또는 mid)
            }
        }
        return left;
    }

    // 일반적인 이진 탐색
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 한쪽은 무조건 정렬이 되어 있기 때문에 성립하는 문제 인데
     * 직관적으로는 이해가 잘안된다
     * [4,5,6,7,8,9,0,1,2] 이런 형태라면 target = 9 일때
     * 절반 8 => 4 ~ 8 정렬된 범위에 타겟이 존재하지 않으므로 9 ~ 2 까지 범위를 선택해야 한다.
     * 다시 절반 0 보다 9가 크기때문에 0 ~ 2 는 정렬된 범위이고 이곳에 target 이 존재하지 않기 때문에
     * mid 인 0 => 9 로 가게 되므로 타겟을 찾게된다.
     * 반으로 자르면 무조건 한쪽은 정렬이 되어 있다는걸 가정하고 생각해야 하는데 생각하기 쉽지 않다
     */
    public static int __search(int[] arr, int target) {
        int low  = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target)
                return mid;

            // 둘중 하나는 반드시 정렬 되어 있다.
            if(arr[low] <= arr[mid]){ // 이조건을 탄 경우 왼쪽이 정렬 되어 있다.
                if(target >= arr[low] && target <= arr[mid]){
                    high  = mid -1;
                }
                else
                    low = mid + 1;
            }
            else{  // 이 조건을 타게 되는경우 오른쪽이 정렬 되어 있다.
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
