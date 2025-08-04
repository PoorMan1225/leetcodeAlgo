package recursion_2;

import java.util.*;

public class Sudoku_Solver {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(chars);
        // 출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        List<int[]> placedList = new ArrayList<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> divides = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
            divides.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') {
                    placedList.add(new int[]{i, j});
                } else {
                    rows.get(i).add(val);
                    columns.get(j).add(val);
                    int divideIndex = (i / 3) * 3 + (j / 3);
                    divides.get(divideIndex).add(val);
                }
            }
        }

        dfs(0, board, placedList, rows, columns, divides);
    }

    public static boolean dfs(int level, char[][] board, List<int[]> placedList,
                              Map<Integer, Set<Character>> rows,
                              Map<Integer, Set<Character>> columns,
                              Map<Integer, Set<Character>> divides) {
        if (level == placedList.size()) {
            return true; // 완성
        }

        int[] p = placedList.get(level);
        int i = p[0];
        int j = p[1];
        int divideIndex = (i / 3) * 3 + (j / 3);

        for (char ch = '1'; ch <= '9'; ch++) {
            if (rows.get(i).contains(ch) || columns.get(j).contains(ch) || divides.get(divideIndex).contains(ch)) {
                continue;
            }

            // 시도
            board[i][j] = ch;
            rows.get(i).add(ch);
            columns.get(j).add(ch);
            divides.get(divideIndex).add(ch);

            if (dfs(level + 1, board, placedList, rows, columns, divides)) {
                return true;
            }

            // 백트래킹
            board[i][j] = '.';
            rows.get(i).remove(ch);
            columns.get(j).remove(ch);
            divides.get(divideIndex).remove(ch);
        }
        return false;
    }
}
