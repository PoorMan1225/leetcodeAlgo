package recursion_2;

import java.util.HashSet;
import java.util.Set;

public class NQueens_2 {
    public static void main(String[] args) {
        final int i = totalNQueens(4);
        System.out.println(i);
    }

    public static int totalNQueens(int n) {
        // 먼저 보드를 정의한다.
        int[][] board = new int[n][n];
        // 행 개수를 체크하고 반환할 함수를 정의한다.
        return countNqueen(board, 0);
    }

    public static int countNqueen(int[][] board, int row) {
        if (row == board.length) return 1;
        // 내가 배치할 곳에 배치가 가능한지 확인하는 함수를 작성한다.
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            if (isPlaced(board, row, i)) {
                board[row][i] = 1;
                cnt += countNqueen(board, row + 1);
                board[row][i] = 0;
            }
        }
        return cnt;
    }

    public static boolean isPlaced(int[][] board, int row, int col) {
        int n = board.length;
        // 각 열 방향 존재하는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] > 0) return false;
        }

        // ↖ 대각선 (좌상)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] > 0) return false;
        }
        // ↗ 대각선 (우상)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] > 0) return false;
        }
        return true;
    }

    public int _totalNQueens(int n) {
        return count(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    /**
     * 이방법이 더 직관적인 방법
     * set 을 전달해서 직관적으로 해결
     */
    private int count(int row, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) return 1;

        int total = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col;

            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) continue;

            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            total += count(row + 1, n, cols, diag1, diag2);

            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
        return total;
    }
}
