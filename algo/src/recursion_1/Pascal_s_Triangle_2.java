package recursion_1;

import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle_2 {
    public static void main(String[] args) {
        final List<Integer> rowK = getRow_k(4);
        System.out.println(rowK);
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }

        List<Integer> prev = getRow(rowIndex - 1);
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        for (int i = 1; i < prev.size(); i++) {
            curr.add(prev.get(i - 1) + prev.get(i));
        }
        curr.add(1);
        return curr;
    }

    /**
     * 여기서 공간을 어떻게 줄일 수 있을까?
     */

    public static List<Integer> getRow_k(int rowIndex) {
        // 먼저 첫번째 값을 담을 리스트 하나를 선언한다.
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // 첫번째는 초기화 했으므로 1 부터 시작한다.
        for (int i = 1; i <= rowIndex; i++) {
            // 이제 값을 덮어 쓰면서 갱신한다.
            // 현재 있던 list 의 마지막 값을 가지고 와서 그전값과 더해서 끝으로 갱신해줘야 한다.
            // 맨앞에 1 까지 갱신할 수는 없으므로 [1, 2, 1] 이라면 [1, 3, 3] 이렇게 갱신 되어야한다.
            // 마지막 부터 갱신해야 오류 없는 값을 갱신할 수 있다. 앞에서 부터 갱신하면 값이 틀어지게 된다.
            for (int j = list.size() - 1; j >= 1; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            list.add(1);
        }
        return list;
    }
}
