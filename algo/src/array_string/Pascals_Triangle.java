package array_string;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        final List<List<Integer>> generate = _generate(5);
        System.out.println("generate = " + generate);
    }

    /**
     * 문제설명
     * 파스칼의 삼각형을 구현하는 문제이다.
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> inner = new ArrayList<>(i + 1);
            if (i == 0) {
                inner.add(1);
            } else if (i == 1) {
                inner.add(1);
                inner.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j > 0 && j <= i - 1) {
                        List<Integer> list = result.get(i - 1);
                        int first = list.get(j - 1);
                        int second = list.get(j);
                        inner.add(first + second);
                    } else {
                        inner.add(1);
                    }
                }
            }
            result.add(inner);
        }
        return result;
    }

    public static List<List<Integer>> _generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            list.add(ans(row, i - 1));
        }
        return list;

    }

    static List<Integer> ans(List<Integer> row, int i) {
        int ans = 1;
        row.add(ans);
        for (int k = 1; k <= i; k++) {
            ans = ans * (i - k + 1);
            ans = ans / k;
            row.add(ans);
        }
        return row;
    }
}
