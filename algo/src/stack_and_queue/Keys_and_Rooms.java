package stack_and_queue;

import java.util.*;

public class Keys_and_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        // 굳이 반복문 돌면서 넣어줄 필요 없다 room index 만 넣고 그것을 조회하면된다.
        for (Integer r : rooms.get(0)) {
            queue.offer(r);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int r = queue.poll();
                if(visited.contains(r)) continue;
                visited.add(r);
                for(Integer nr : rooms.get(r)) {
                    queue.offer(nr);
                }
            }
        }
        // 그냥 사이즈로 비교하면 된다 어차피 set 이라서 중복이 없기 때문에 그리고
        // room 배열을 벗어나는 경우도 없다.
        for(int i=0; i<rooms.size(); i++) {
            if(!visited.contains(i)) return false;
        }
        return true;
    }

    public boolean __canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.offer(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    /**
     * DFS 방식
     */
    public boolean canVisitAllRoomsDfs(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited)
                return false;
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
