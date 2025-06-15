package stack_and_queue;

import java.util.Stack;

public class Flood_Fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<int[]> stack = new Stack<>();
        int[][] visited = new int[image.length][image[0].length];
        stack.push(new int[]{sr, sc});
        visited[sr][sc] = 1;

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (!stack.isEmpty()) {
            int[] value = stack.pop();
            int eColor = image[value[0]][value[1]];
            image[value[0]][value[1]] = color;

            for (int i = 0; i < dx.length; i++) {
                int ny = value[0] + dy[i];
                int nx = value[1] + dx[i];

                if (ny >= 0 && ny < image.length && nx >= 0 && nx < image[0].length && image[ny][nx] == eColor && visited[ny][nx] < 1) {
                    stack.push(new int[]{ny, nx});
                    visited[ny][nx] = 1;
                }
            }
        }
        return image;
    }
}
