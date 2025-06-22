package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Index_Sum_of_Two_List {
    public static void main(String[] args) {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int leastIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = map.get(list2[i]) + i;
                if(leastIndex > indexSum) {
                    leastIndex = Math.min(leastIndex, indexSum);
                    map.put(list2[i], indexSum);
                    result.clear(); // 이전에 들어갔던 녀석들은 모두 최소 값이 아니었다.
                    result.add(list2[i]);
                } else if(leastIndex == indexSum) {
                    map.put(list2[i], indexSum);
                }
            }
        }
        return result.toArray(String[]::new);
    }
}
