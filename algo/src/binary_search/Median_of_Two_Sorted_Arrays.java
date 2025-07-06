package binary_search;

public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {

    }

    // (m + n + 1) / 2 => 홀수개수 이면 중간값을 포함하기 위해서  + 1 을 해준다
    // ex) (4 + 5 + 1) / 2 라면 홀수개수 이므로 + 1 해서 짝수가 되어서 중간값 포함.
    // 짝수 개수 라면 + 1 해도 홀수가 되므로 그냥 짝수 값
    //  - i 를 해주는 것은  왼쪽에 넣어야할 개수가 (m + n + 1) / 2 - i 가 되어야 하기 때문에
    // 즉 j 는 오른쪽의 최소값 j-1 은 왼쪽의 최대값 이된다.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 항상 nums1이 더 짧은 배열이 되도록 보장
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;           // nums1 쪽 컷
            int j = (m + n + 1) / 2 - i;        // num2 쪽 컷

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1]; // A 배열의 왼족 컷의 최대값
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];    // A 배열의 오른족 컷의 최소값.

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1]; // B 배열의 왼쪽 콧의 최대 값
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];    // B 배열의 오른쪽 컷의 최소 값

            // 왼쪽 블럭  값들 은 절대로 오른쪽 블럭보다 클 수 없음
            // 크로스로 블럭을 교차해서 비교해보았을때 절대 클 수 없으므로 왼쪽 블럭들의 최대값과 오른족 블럭들의 최소값을 모으게 되면
            // 중앙 값이 나온다.
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    // 짝수의 경우 두개의 큰값과 작은값의 평균을 구하면 된다 .
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    // 홀수의 경우 그냥 최대값을 구하면 그게 중간값이다.
                    return Math.max(maxLeftA, maxLeftB);
                }
                // maxLeftA 가 더크다는 사실은 크로스로 교차 해서 정렬할 수 없는 상태이므로
                // left 의 값을 줄여야 하므로 high - 1
            } else if (maxLeftA > minRightB) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
