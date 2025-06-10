package stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures {
    public static void main(String[] args) {
        final int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 스택에서 작은 값을 찾아서 처리 했다. 통과는 했지만 효율성 점수가 조금 떨어지는 것 같은데 더좋은 방법을 모르겠다.
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // 스택에 인덱스만 저장해도 된다.
        // 2. 한번씩 반복을 돌면서 자기보다 작은 값을 찾는다
        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[1] < current) { // 스택에 인덱스만 저장했다면 peek 값로 temperatures 를 접근하면 된다.
                // 3. 찾았다면 해당 인덱스 에서 뺀값을 결과에 집어넣는다.
                int[] before = stack.pop();
                result[before[0]] = i - before[0];
            }
            stack.push(new int[]{i, current});
        }
        return result;
    }
}
