package recursion_1;

public class Climbing_Stairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] memo = saveStairs(n);
        return memo[n];
    }

    public int[] saveStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = i <= 2 ? i : memo[i - 1] + memo[i - 2];
        }
        return memo;
    }
}
