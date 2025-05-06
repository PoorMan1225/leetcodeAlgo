package easy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        final int[] test1 = {2, 7, 11, 15};
        final int[] test2 = {3, 2, 4};
        final int[] test3 = {3, 3};
//        final int[] r1 = twoSum(test1, 9);
        final int[] r2 = twoSum(test2, 6);
//        final int[] r3 = twoSum(test3, 6);

//        System.out.println("r1 = " + Arrays.toString(r1));
        System.out.println("r2 = " + Arrays.toString(r2));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[][] arr = new int[nums.length][2];
        for(int i=0; i<nums.length; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];
            if (target == sum) {
                return new int[]{ arr[left][1], arr[right][1] };
            } else if (target < sum) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        throw new RuntimeException();
    }

    /**
     * 정답 코드.
     * 정답코드로 할 경우에 굳이 정렬을 해줄 필요가 없다.
     * 예를 들어 [2, 7, 11, 15] 인데 target 이 9 라면
     * 이경우 7이 보완값이 되는데 보완값이 없으므로 2가 그냥 들어가게 되고.
     * 7의 경우 2가 보완값이 되어 존재하기 때문에 바로 [0, 1] 이 정답이 된다.
     */
    public int[] twoSum_solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 보완 값을 구한다.
            int complement = target - nums[i];
            // 보완값이 존재할 경우
            if (map.containsKey(complement)) {
                // 보완값과 현재 index 를 리턴한다.
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
