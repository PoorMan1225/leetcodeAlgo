package recursion_2;

public class Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return getRangeLargestRectangleArea(heights, 0, heights.length - 1);
    }

    private int getRangeLargestRectangleArea(int[] heights, int left, int right) {
        // 기저 조건: 범위가 잘못된 경우
        if (left > right) return 0;
        if (left == right) return heights[left]; // 한 칸만 있는 경우

        // 최소 높이 인덱스 찾기
        int minIndex = left;
        for (int i = left; i <= right; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        // 최소값을 기준으로 세 부분 중 최대값을 구함
        int leftMax = getRangeLargestRectangleArea(heights, left, minIndex - 1);
        int rightMax = getRangeLargestRectangleArea(heights, minIndex + 1, right);
        int crossMax = heights[minIndex] * (right - left + 1);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
}
