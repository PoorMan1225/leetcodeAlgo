package stack_and_queue;

import java.util.*;

public class Open_the_Lock {
    public static void main(String[] args) {
        char[] init = new char[]{'0', '0', '0', '0'};
    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return level;

                for (String next : getNextStates(curr)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private List<String> getNextStates(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // up
            chars[i] = original == '9' ? '0' : (char)(original + 1);
            res.add(new String(chars));

            // down
            chars[i] = original == '0' ? '9' : (char)(original - 1);
            res.add(new String(chars));

            // 복원
            chars[i] = original;
        }
        return res;
    }
}
