package stack_and_queue;

import java.util.*;

public class Perfect_Squares {
    public static void main(String[] args) {

    }

    /**
     * 제곱수 로 만들 수 있는 최소값을 반환하는 문제 queue 로 풀었는데
     * 통과는 했지만 효율성에서 점수가 낮게 나오는걸 보니 더 좋은 방법이 있을것 같다.
     */
    public static int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; (i * i) <= n; i++) {
            list.add(i * i);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                for (int number : list) {
                    if (value - number == 0) return level;
//                    if (value - number < 0) continue;
                    if (value - number < 0) break; // 어차피 다음 수가 무조건 크기 때문에 break 로 끊는게 낫다.
                    if (!visited.contains(value - number)) {
                        queue.offer(value - number);
                        visited.add(value - number);
                    }
                }
            }
        }
        return level;
    }

    /**
     * Dynamic Programming
     * 여기서 dp 는 어떤수 를 제곱수로 표현했을때 최소 횟수를 나타낸다.
     * dp 는 재귀구조랑 굉장히 유사한데 재귀구조가 top - down 방식이라면 dp 는 bottom - up 구조이다.
     * 그래서 재귀 구조를 잘 익혀둬야 dp 구조까지 점진적으로 나아가기 쉽다.
     */
    public static int __numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 처음엔 모두 큰 수로 초기화
        dp[0] = 0; // 0을 만들기 위한 제곱수 개수는 0

        for (int i = 1; i <= n; i++) { // 1부터 n까지 채워나감
            for (int j = 1; j * j <= i; j++) { // j*j는 i보다 작거나 같은 제곱수
                // i - j*j 는 j*j 제곱수를 사용했을대 남은 최소의 개수 + 1 이므로 그 값의 최소값을 계속 갱신한다.
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 최소 개수 갱신
            }
        }
        return dp[n]; // 정답: n을 만들기 위한 최소 제곱수 개수
    }

    /**
     * 재귀 구조
     */
    public static int ___numSqaures(int n) {
        if (n == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, ___numSqaures(n - i * i) + 1);
        }
        return min;
    }
}
