package binary_search;

public class Find_Minimum_in_Rotated_Sorted_Array_2 {
    public static void main(String[] args) {

    }

    /* 솔직히 이거 못풀었따.
        두개가 중복이 되는 문제 때문에 왼쪽으로 가지 못하고 오른쪽으로도 가지 못하는걸 알고 있기는 햇는데
        한칸씩 줄이는건 생각을 못함.
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[right] > nums[mid]) {
                right = mid;
            } else if(nums[right] < nums[mid]){
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}
