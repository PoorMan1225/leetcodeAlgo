package recursion_2;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        int[] remain = new int[k];
        List<List<Integer>> result = new ArrayList<>();
        recur(0, 1, k, n, remain, result);
        return result;
    }

    public void recur(int level, int v, int k, int n, int[] remain, List<List<Integer>> result) {
        if (level == k) {
            List<Integer> list = new ArrayList<Integer>(k);
            for (int i = 0; i < k; i++) list.add(remain[i]);
            result.add(list);
            return;
        }
        for (int i = v; i <= n; i++) {
            remain[level] = i;
            recur(level + 1, i + 1, k, n, remain, result);
        }
    }

    public List<List<Integer>> __combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 가지치기 최적화
        // 수학적으로 선택 할 수 있는 개수를 줄임
        // n - (k + 1) 여기서 현재 내가 선택한 숫자를 빼줘야 최적화가 가능해진다.
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
