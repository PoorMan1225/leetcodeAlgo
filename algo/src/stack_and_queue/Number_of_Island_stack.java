package stack_and_queue;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Number_of_Island_stack {
    public static void main(String[] args) {
        // 1
        char[][] test1 = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };
        // 3
        char[][] test2 = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };

//        final int r1 = numIslandsDfsRecur(test1);
//        System.out.println("r1 = " + r1);
//        final int r2 = numIslandsDfsRecur(test2);
//        System.out.println("r2 = " + r2);

        final int r1 = numIslandsDfsStack(test1);
        System.out.println("r1 = " + r1);
        final int r2 = numIslandsDfsStack(test2);
        System.out.println("r2 = " + r2);
    }

    /**
     * DFS 방식으로 섬 개수를 센 코드 작성
     */
    public static int numIslandsDfsRecur(char[][] grid) {
        Set<Point> visted = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Point p = new Point(j, i);
                if (grid[i][j] == '1' && !visted.contains(p)) {
                    numIslandsDfsRecur(grid, p, visted);
                    count++;
                }
            }
        }
        return count;
    }

    public static void numIslandsDfsRecur(char[][] grid, Point p, Set<Point> visited) {
        if (p.x >= grid[0].length || p.x < 0 || p.y >= grid.length || p.y < 0 || visited.contains(p) || grid[p.y][p.x] != '1')
            return;
        visited.add(p);
        numIslandsDfsRecur(grid, new Point(p.x + 1, p.y), visited); // 동
        numIslandsDfsRecur(grid, new Point(p.x, p.y + 1), visited); // 남
        numIslandsDfsRecur(grid, new Point(p.x - 1, p.y), visited); // 서
        numIslandsDfsRecur(grid, new Point(p.x, p.y - 1), visited); // 북
    }

    /**
     * DFS 방식이지만 Stack 을 사용해서 섬개수를 센 코드 작성 - 재귀 구조를 스택으로 변경
     * 재귀와 스택의 차이점은 재귀는 마지막 루트 노드가 마지막에 팝되는 반면 스택에서는 바로 팝을 하고 시작한다.
     * 그리고 스택으로 구현하면 LIFO 구조기 때문에 마지막에 넣은 값이 첫번째로 나오기 때문에 재귀 구현과 방향을 반대로 집어넣어야 한다. (그래야 같은 방향 유지)
     */
    public static int numIslandsDfsStack(char[][] grid) {
        Set<Point> visted = new HashSet<>();
        Stack<Point> stack = new Stack<>();
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Point p = new Point(j, i);
                if (grid[i][j] == '1' && !visted.contains(p)) {
                    stack.push(p); // root 를 푸시한다.

                    while (!stack.isEmpty()) {
                        Point cp = stack.pop();
                        if (cp.x >= grid[0].length || cp.x < 0 || cp.y >= grid.length || cp.y < 0 || visted.contains(cp) || grid[cp.y][cp.x] != '1')
                            continue;

                        visted.add(cp);
                        for(int k=0; k<dx.length; k++) {
                            Point np = new Point(cp.x + dx[k], cp.y + dy[k]);
                            stack.push(np);
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
