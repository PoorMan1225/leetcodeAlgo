package recursion_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        int[] value = new int[nums.length];

        dfs(0, result, check, nums, value);
        return result;
    }

    public static void dfs(int level, List<List<Integer>> result, boolean[] check, int[] nums, int[] value) {
        if (level == nums.length) {
            // 배열 value -> 리스트로 변환
            List<Integer> list = new ArrayList<>();
            for (int v : value) list.add(v);
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;           // i번째 숫자 사용
                value[level] = nums[i];    // 현재 위치(level)에 배치
                dfs(level + 1, result, check, nums, value); // 다음 단계 탐색
                check[i] = false;          // 사용 해제(백트래킹)
            }
        }
    }
}
