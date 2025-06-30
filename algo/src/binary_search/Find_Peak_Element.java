package binary_search;

public class Find_Peak_Element {
    public static void main(String[] args) {

    }

    // 일단 peek 의 정확한 인덱스를 찾아야 하기 때문에 템플릿2 를 사용해야 하고
    // 그다음 양 끝 쪽이 무한대의 음수 이기 때문에 피크값이 반드시 존재한다.
    // 그래서 이진 탐색으로 하나의 피크만 찾으면 되기 때문에 이코드가 성립하는데
    // 문제자체가 그냥 별로 인것 같다
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // 오른쪽에 peak가 있음
                left = mid + 1;
            } else {
                // 왼쪽에 peak가 있거나 mid가 peak일 수 있음
                right = mid;
            }
        }

        return left; // 또는 right (left == right)
    }
}
