package recursion_2;

public class Search_a_2D_Matrix_2 {

    /**
     * z index 코드
     * 오른쪽 맨 끝에서 시작해서 값이 크면 한칸 아래(행을 배제)
     * 값이 작으면 한칸 왼쪽으로 (열을 배제) 이런식으로 target 값이 있을때 까지 찾는다.
     */
    public boolean __searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;  // 오른쪽 위에서 시작

        while (row < matrix.length && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                col--;  // 왼쪽으로 이동
            } else {
                row++;  // 아래로 이동
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    /**
     * 코드의 설명에 따라서 이코드는 4분면에서 하나의 기저 조건을 배제하고 나머지 3부분에서 탐색을 하는 코드이다.
     * 이코드는 최악의 경우 o(m x n) 으로 굉장히 비효율적으로 되지만 그 안의 분할정복 아이디어는 참고할만하다.
     * rowStart 와 rowEnd 를 통해서 행의 중간값과 colStart 와 colEnd 를 통해서 열의 중간값을 찾아서
     * 진짜 중간값을 체크하고 거기에 기저 조건을 체크 한 후에 나머지 3개의 사분면을 배제한다.
     *
     * target < mid value
     *  타겟이 중간값보다 작을 경우에 탐색해야 할 조건은 좌상단, 좌하단, 우상단 이 되고
     * target > mid value
     *  타겟이 중간값 보다 클 경우 탐색해야 할 조건은 우상단, 우하단, 좌하단 이 이된다.
     *
     *  재귀는 흐름이 아니라 범위로 봐야한다. 이부분이 정말 중요하다. 값 하나하나를 보는게 아니라 전체 범위를 보고 판단을 내려야 하는것.
     */
    private boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        // 기저조건: 영역이 유효하지 않으면 false 반환
        if (rowStart > rowEnd || colStart > colEnd)
            return false;

        // 현재 부분 행렬의 최소값, 최대값 확인 후 범위 밖이면 false
        if (target < matrix[rowStart][colStart] || target > matrix[rowEnd][colEnd])
            return false;

        int midRow = (rowStart + rowEnd) / 2;
        int midCol = (colStart + colEnd) / 2;
        int midVal = matrix[midRow][midCol];

        if (midVal == target)
            return true;
        else if (midVal < target) {
            // target이 midVal보다 크면 오른쪽 상단과 오른쪽 하단, 왼쪽 하단 영역 탐색
            return search(matrix, target, rowStart, midRow, midCol + 1, colEnd) ||
                    search(matrix, target, midRow + 1, rowEnd, colStart, colEnd);
        } else {
            // target이 midVal보다 작으면 왼쪽 상단과 왼쪽 하단, 오른쪽 상단 영역 탐색
            return search(matrix, target, rowStart, midRow - 1, colStart, midCol - 1) ||
                    search(matrix, target, rowStart, midRow - 1, midCol, colEnd) ||
                    search(matrix, target, midRow, rowEnd, colStart, midCol - 1);
        }
    }
}
