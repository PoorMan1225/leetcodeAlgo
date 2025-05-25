package array_string;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_2 {
    public static void main(String[] args) {
        final List<Integer> row = __getRow(3);
        System.out.println("row = " + row);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        if (rowIndex == 0) return list.get(0);
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        if (rowIndex == 1) return list.get(1);
        for (int i = 2; i <= rowIndex; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.get(i).add(1);
                } else {
                    int v1 = list.get(i - 1).get(j - 1);
                    int v2 = list.get(i - 1).get(j);
                    list.get(i).add(v1 + v2);
                }
            }
        }
        return list.get(rowIndex);
    }

    /**
     * List 한줄로 해당 인덱스의 값을 구하는 방식
     * 하나의 리스트를 인덱스의 값을 체인지 하면서 특정 로우의 컬럼 들을 만든다.
     * 이경우 컬럼의 값을 생성할때 앞에서 부터 하면 안되는데 왜냐하면 변경된 값이 적용 되어서 이상하게 되기 때문에
     * 뒤로 해야 한다 (ex) 1, 2, 1 -> 1, 3, 4, 1)
     */
    public static List<Integer> __getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}
