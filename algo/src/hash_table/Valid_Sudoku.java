package hash_table;

import java.util.HashSet;

public class Valid_Sudoku {
    public static void main(String[] args) {

    }

    /**
     * 걍 있는 그대로 풀었는데 생각해보니 해쉬로 풀 수 있을거 같은데 왜 이걸로 했는지 모르겠다
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    // 1. 행 검증
                    if (!isRowCheck(i, j, board)) return false;
                    // 2. 열 검증
                    if (!isColCheck(i, j, board)) return false;
                    // 3. 3개 범위 체크
                    if (!isBoxCheck(i, j, board)) return false;
                }
            }
        }
        return true;
    }

    public boolean isRowCheck(int i, int j, char[][] board) {
        for (int k = 0; k < board[i].length; k++) {
            if (j == k) continue;
            if (board[i][k] == board[i][j]) return false;
        }
        return true;
    }

    public boolean isColCheck(int i, int j, char[][] board) {
        for (int k = 0; k < board.length; k++) {
            if (i == k) continue;
            if (board[k][j] == board[i][j]) return false;
        }
        return true;
    }

    public boolean isBoxCheck(int i, int j, char[][] board) {
        int rangeI = (i / 3) * 3;
        int rangeJ = (j / 3) * 3;

        for (int k = rangeI; k < rangeI + 3; k++) {
            for (int l = rangeJ; l < rangeJ + 3; l++) {
                if (i == k && j == l) continue;
                if (board[i][j] == board[k][l]) return false;
            }
        }
        return true;
    }

    /**
     * 해쉬 를 사용한 방식 풀이
     * 9 x 9 칸 배열을 3 x 3 칸 배열로 변경 => [(i / 3), (j / 3)]
     * 3 x 3 이차원 배열을 9칸 1차원 배열로 변경 => (i x 행개수) + j
     * (i / 3) x 3 + (j / 3)
     */
    public boolean __isValidSudoku(char[][] board) {
        // row 결과를 저장할 HashSet 을 설정한다.
        // row 는 9칸이니까 9개의 HashSet 을 만든다.
        // col 결과를 저장할 HashSet 을 설정한다.
        // col 는 9칸이니까 9개의 HashSet 을 만든다.
        // box 결과를 저장할 HashSet 을 설정한다.
        // box 는 9칸이니까 9개의 HashSet 을 만든다.
        HashSet<Character>[] containsRow = new HashSet[9];
        HashSet<Character>[] containsCol = new HashSet[9];
        HashSet<Character>[] containsBox = new HashSet[9];

        // 데이터를 채운다.
        for (int i = 0; i < board.length; i++) {
            containsRow[i] = new HashSet<>();
            containsCol[i] = new HashSet<>();
            containsBox[i] = new HashSet<>();
        }

        // 해당 데이터가 있는지 판단을 한다.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') continue;
                // 행 검사.
                if(!containsRow[i].contains(board[i][j])) return false;
                containsRow[i].add(board[i][j]);
                // 열 검사
                if(!containsCol[j].contains(board[i][j])) return false;
                containsCol[j].add(board[i][j]);
                // box 검사
                int index = (i / 3) * 3 + (j / 3);
                if(!containsBox[index].contains(board[i][j])) return false;
                containsBox[index].add(board[i][j]);
            }
        }
        return true;
    }
}
