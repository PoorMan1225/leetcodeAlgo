package array_string;

public class Two_Sum_2 {
    public static void main(String[] args) {

    }

    /**
     * 정수 오버 플로 방지.
     * left + (right - left) / 2
     * = left + (right / 2 - left / 2)     ← 분배법칙
     * = (left - left / 2) + right / 2
     * = left * (1 - 1/2) + right / 2
     * = left / 2 + right / 2
     * = (left + right) / 2 <- 이부분은 정수 오버 플로가 발생할 수 있음.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};

            int mid = left + (right - left) / 2; // 정수 오버 플로 방지

            if (sum < target) {
                // 왼쪽 합이 작으니까 left를 오른쪽으로 올리긴 해야 함
                // 근데 mid도 활용해서 한 번에 많이 점프할 수 있는지 판단
                if (numbers[mid] + numbers[right] < target) {
                    left = mid + 1;
                } else {
                    left = left + 1;
                }
            } else {
                // 합이 크니까 right를 줄여야 함
                // mid를 써서 줄일 수 있으면 줄여 봄
                if (numbers[mid] + numbers[left] > target) {
                    right = mid - 1;
                } else {
                    right = right - 1;
                }
            }
        }
        return new int[2];
    }
}
