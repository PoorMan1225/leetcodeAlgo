package array;

import java.util.Arrays;
import java.util.TreeSet;

public class Third_Maximum_Number {
    public static void main(String[] args) {

    }

    /**
     * 문제 설명
     * 임의의 정수 배열이 주어지면 이배열에서 세번째 고유한 최댓값을 반환한다.
     * o(n) 의 알고리즘이 생각이 안나기 때문에 nlogn 으로 일단 푼다.
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        int count = 3;
        if (set.size() < count) {
            return set.pollLast();
        }
        int result = -1;
        while (count > 0) {
            result = set.pollLast();
            count--;
        }
        return result;
    }

    /**
     * 되게 당연해 보이는 아이디어 같기도 하다.
     * 3번째 최대 값을 구하면 되는 문제 이기 때문에 3개의 변수를 마련해놓고
     * 반복문을 돌면서 세번째 값보다 작은 값들을 뒤로 밀어넣어주는 식으로 근데 같은 경우는 제외하고
     * 넣게 되니까 o(n) 으로 해결된다.
     */
    public int _thirdMax(int[] nums) {
        // 초기 최소값 지정
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;

        for (int num : nums) {
            // max1 보다 크다면 가장 큰값이므로 max2, max3 을 뒤로 민다.
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            // max1 보다 작은데 max1 과 같은 경우를 제외해야 한다.
            // 왜냐하면 같은 값이 중복해서 들어가서는 안되기 때문이다.
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = num;
            // max2 보다 작은값 그리고 중복이 안되는 값을 max3 에 넣는다.
            } else if (num > max3 && num != max1 && num != max2) {
                max3 = num;
            }
        }
        // max3 이 가장 작은 값이라면 값이 두개 이하이므로 최대값을 반환
        // 아닐경우 세번째 최대값인 max3 을 반환한다.
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }
}
