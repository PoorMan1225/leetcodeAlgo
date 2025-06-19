package hash_table;

/**
 * Hash 에서 1:1 대응을 포기를 하고
 * 시간 복잡도를 포기를 하고 공간을 선택.
 */
public class MyHashMap2 {

    static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] bucket;
    private final int capacity = 1000;

    public MyHashMap2() {
        bucket = new Node[capacity];
    }

    // 이함수의 역할은
    // 0 -> 0 인덱스  반환
    // 1,000 -> 0 인덱스 반환
    // 1,000,000 -> 0 인덱스 반환
    public int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        // 이전에 값이 없는 경우
        if (bucket[index] == null) {
            // 새로운 노드를 생성하고 buket 을 업데이트 한다.
            bucket[index] = new Node(key, value);
            return;
        }
        // 이전에 값이 있는 경우
        Node prev = null;
        Node cur = bucket[index];
        while (cur != null) {
            // 현재 내가 들어온 key 의 값을 찾는다.
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        // 마지막 까지 갔는데도 내 키를 못찾았은 경우
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        // 가져올려고 했는데 없는 경우
        if (bucket[index] == null) return -1;
        // 현재 내 키와 같은 Node 를 찾는다.
        Node cur = bucket[index];
        while (cur != null) {
            if (cur.key == key) return cur.value;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (bucket[index] == null) return;

        Node prev = null;
        Node cur = bucket[index];
        while (cur != null) {
            if (cur.key != key) {
                prev = cur;
                cur = cur.next;
                continue;
            };
            if(prev != null) {
                prev.next = cur.next;
            } else {
                bucket[index] = cur.next;
            }
            return;
        }
    }
}
