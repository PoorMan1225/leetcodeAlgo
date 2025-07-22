package recursion_1;

public class Tail_Recursion {
    private static int helper_non_tail_recursion(int start, int [] ls) {
        if (start >= ls.length) {
            return 0;
        }
        // not a tail recursion because it does some computation after the recursive call returned.
        return ls[start] + helper_non_tail_recursion(start+1, ls);
    }

    public static int sum_non_tail_recursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_non_tail_recursion(0, ls);
    }

    //---------------------------------------------
    // 꼬리 재귀는 이렇게 재귀 하나만 리턴 하는 재귀함수로 파라미터를 다 넘겨서 호출한 스택 자체가
    // 의미 없어지는 경우에 스택을 하나만 계속 덮어서 공간을 o(1) 로만들 수 있다. 물론 자바 에서는 안되고
    // 공간이 중요한 언어 에서 중요하게 다뤄진다.
    private static int helper_tail_recursion(int start, int [] ls, int acc) {
        if (start >= ls.length) {
            return acc;
        }
        // this is a tail recursion because the final instruction is the recursive call.
        return helper_tail_recursion(start+1, ls, acc+ls[start]);
    }

    public static int sum_tail_recursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_tail_recursion(0, ls, 0);
    }
}
