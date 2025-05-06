package array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 1;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        max = Math.max(max, count);
        return max;
    }


}
