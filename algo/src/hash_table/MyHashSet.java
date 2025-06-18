package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 해시를 하면서 공간이 근데 10^6 이니까 1_000_000 이런 형태일 텐데
 * 이대로 하면 뭔가 공간낭비가 너무 심하단 생각이 들어서 작게 분할 할당을
 * 하는 식으로 만들었다
 */
public class MyHashSet {
    private final int BUCKET_SIZE = 100;
    private List<int[]> storage;

    public MyHashSet() {
        storage = new ArrayList<>();
    }

    public void add(int key) {
        int outerIndex = key / BUCKET_SIZE;
        int innerIndex = key % BUCKET_SIZE;

        // storage 확장
        while (storage.size() <= outerIndex) {
            int[] arr = new int[BUCKET_SIZE];
            Arrays.fill(arr, -1);
            storage.add(arr);
        }

        storage.get(outerIndex)[innerIndex] = key;
    }

    public void remove(int key) {
        int outerIndex = key / BUCKET_SIZE;
        int innerIndex = key % BUCKET_SIZE;

        if (outerIndex >= storage.size()) return;

        storage.get(outerIndex)[innerIndex] = -1;
    }

    public boolean contains(int key) {
        int outerIndex = key / BUCKET_SIZE;
        int innerIndex = key % BUCKET_SIZE;

        if (outerIndex >= storage.size()) return false;

        return storage.get(outerIndex)[innerIndex] == key;
    }
}
