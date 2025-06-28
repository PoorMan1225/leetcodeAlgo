package hash_table;

import java.util.*;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    // 그냥 삭제를 하면 o(1) 이 안도니까 스왑을 해야한다.
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);                   // val 의 인덱스를 찾는다.
            int lastValue = list.get(list.size() - 1);  // 리스트의 마지막 값을 가지고 온다.

            list.set(index, lastValue);                 // 마지막 값과 현재 인덱스의 값을 변경한다.
            map.put(lastValue, index);

            list.remove(list.size() - 1);         // 마지막 값을 삭제 한다.
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        if(list.isEmpty()) return -1;
        int randIdx = random.nextInt(list.size());
        return list.get(randIdx);
    }
}
