package array_string;

import java.util.Arrays;

public class Diagonal_Traverse {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2},
                {4, 5},
                {7, 8},
        };
        final int[] diagonalOrderSimulation = findDiagonalOrderSimulation(input);
        System.out.println("Arrays.toString(diagonalOrderSimulation) = " + Arrays.toString(diagonalOrderSimulation));
    }

    /**
     * 문제설명
     * m x n 이 주어지면 배열의 모든 요소를 대각선 순서로 배열한 배열을 반환한다.
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        // 1. 먼저 결과를 담을 배열을 선언한다.
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        for (int s = 0; s < m + n - 1; s++) {
            if (s % 2 == 0) {
                // 위로 올라가는 대각선 ↗
                int r = Math.min(s, m - 1); // 최대 로우 인덱스를 가지고온다.
                int c = s - r; // s = 행 + 열이므로 column 은 s - 행 이다.
                while (r >= 0 && c < n) {
                    result[index++] = mat[r--][c++];
                }
            } else {
                // 아래로 내려가는 대각선 ↙
                int c = Math.min(s, n - 1); // 최대 컬럼 인덱스를 가지고 온다.
                int r = s - c;
                while (c >= 0 && r < m) {
                    result[index++] = mat[r++][c--];
                }
            }
        }
        return result;
    }

    /**
     * 사실 이런문제의 경우 시뮬레이션으로 구하는게
     * 훨씬 더 빨리 구할 수 있을것 같다. 그게더 직관적이고 어떻게보면 사각 달팽이와 같기 때문에 시뮬레이션으로
     * 구하는게 더 좋을 수 있다.
     *
     * 인덱스를 증가시키는 부분을 while 로 처리를 해보자.
     */

    public static int[] findDiagonalOrderSimulation(int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;
        int[] result = new int[n * m];
        boolean isUp = true;

        int index = 0;
        int x = 0;
        int y = 0;
        result[index++] = mat[y][x];

        while (x != n - 1 || y != m - 1) {
            if (isUp) {
                if (x + 1 < n && y - 1 >= 0) {
                    x++;
                    y--;
                    result[index++] = mat[y][x];
                } else if (x + 1 < n && y - 1 < 0) {
                    x++;
                    result[index++] = mat[y][x];
                    isUp = false;
                } else if (x + 1 >= n) {
                    y++;
                    result[index++] = mat[y][x];
                    isUp = false;
                }
            } else {
                if (x - 1 >= 0 && y + 1 < m) {
                    x--;
                    y++;
                    result[index++] = mat[y][x];
                } else if (y + 1 < m && x - 1 < 0) {
                    y++;
                    result[index++] = mat[y][x];
                    isUp = true;
                } else if (y + 1 >= m) {
                    x++;
                    result[index++] = mat[y][x];
                    isUp = true;
                }
            }
        }
        return result;
    }
}
