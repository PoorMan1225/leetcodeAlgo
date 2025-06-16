package stack_and_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Matrix {

    public static void main(String[] args) {

    }

    /**
     * 코스트 계산 방식
     * 사실 코스트 계산 방식 보다 bfs 의 한레벨이 최단 거리라는 성질을 이용해서
     * 한칸씩 전진한게 최단 거리가 되는 방식을 이용하는게 더 효과적이다  즉 모든 0노드를 찾아서
     * 0기준으로 퍼져나가게 하면 자연스럽게 최단 거리가 되니까 좀더 효과적이게 된다.
     */
    public static int[][] updateMatrix(int[][] mat) {
        int[][] cost = new int[mat.length][mat[0].length];
        for (int[] ints : cost) Arrays.fill(ints, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                if (mat[y][x] == 0) {
                    cost[y][x] = 0;
                    queue.offer(new int[]{y, x});
                }
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int cy = v[0];
            int cx = v[1];

            for (int x = 0; x < dx.length; x++) {
                int ny = cy + dy[x];
                int nx = cx + dx[x];

                if (ny >= 0 && ny < mat.length && nx >= 0 && nx < mat[0].length) {
                    int cv = cost[cy][cx] + 1; // 0까지의 거리니까 항상 +1
                    if (cv < cost[ny][nx]) {
                        cost[ny][nx] = cv;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        return cost;
    }
}
