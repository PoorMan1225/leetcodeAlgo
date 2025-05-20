package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral_Matrix {
    public static void main(String[] args) {
        final List<Integer> result = spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 8},
                {7, 8, 9, 21}
        });
        System.out.println("result = " + result);
    }

    /**
     * 문제설명
     * 달팽이처럼 동, 남, 서, 북 기준으로 이동하게된다.
     * 기본적인 시뮬레이션 문제이다.
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int x = -1;
        int y = 0;
        List<Integer> result = new ArrayList<>(101);
        boolean[][] checkArray = new boolean[m][n];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int index = 0;

        int i = 0;
        for (i = 0; i < n * m; ) {
            int nx = x + dx[index % 4];
            int ny = y + dy[index % 4];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !checkArray[ny][nx]) {
                result.add(matrix[ny][nx]);
                checkArray[ny][nx] = true;
                x = nx;
                y = ny;
                i++;
            } else {
                index++;
            }
        }
        return result;
    }

    /**
     * 4방향 인덱스를 두고 탐색하는 방법
     */
    public List<Integer> _spiralOrder(int[][] arr) {
        int top = 0;
        int bottom = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while (left <= right && top <= bottom) {
            // 동쪽 방향으로 이동.
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;

            // 남쪽 방향으로 이동
            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;

            // 서쪽으로 방향으로 이동.
            // 같아지는 시점에서는 이동되어서는 안되기 때문에 예외처리
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }

            // 북쪽 으로 이동
            // 같아지는 시점에서는 이동되어서는 안되기 때문에 예외처리
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
