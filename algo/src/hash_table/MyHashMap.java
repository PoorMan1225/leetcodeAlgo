package hash_table;

public class MyHashMap {

    private final int CAPACITY = 1_000_001;
    private boolean[] inCheck;
    private int[] stroage;

    public MyHashMap() {
        stroage = new int[CAPACITY];
        inCheck = new boolean[CAPACITY];
    }

    public void put(int key, int value) {
        stroage[key] = value;
        inCheck[key] = true;
    }

    public int get(int key) {
        if (!inCheck[key]) return -1;
        return stroage[key];
    }

    public void remove(int key) {
        inCheck[key] = false;
    }
}


