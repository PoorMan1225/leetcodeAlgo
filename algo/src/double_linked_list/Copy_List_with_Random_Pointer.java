package double_linked_list;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "h");
        map.put(2, "s");
        map.put(3, "e");
        map.put(4, "d");

        String value = map.get(null);
        System.out.println(value == null ? "null" : "dd");
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 주어진 노드를 깊은 복사 하는 문제.
     * 추가 적인 공간을 통해서 문제 해결
     */
    private static Node copyRandomListV1(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 이렇게 hash code 로 작성하는 것보다 그냥 일반 클래스로 key 를 지정하는게 나음
        // 두객체가 다르지만 같은 해시값을 가질 수 있기 때문.
        Map<Integer, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur.hashCode(), new Node(cur.val));
            cur = cur.next;
        }
        Node copyHead = map.get(head.hashCode());
        Node result = copyHead;  // 이부분도 필요 없음. 그냥 map.get(head) 로 가져오면됨.
        while (head != null) {
            // 조건문 자체가 필요 없음 map.get 은 값이 없으면 그냥 null 을 반환하기 때문.
            if (head.next != null) {
                copyHead.next = map.get(head.next.hashCode());
            }
            if (head.random != null) {
                copyHead.random = map.get(head.random.hashCode());
            }
            head = head.next;
            copyHead = copyHead.next;
        }
        return result;
    }

    /**
     * 내가 짠 코드 개선 버전
     */
    private static Node copyRandomListV2(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        Node copyHead = map.get(head);
        while (head != null) {
            copyHead.next = map.get(head.next);
            copyHead.random = map.get(head.random);
            head = head.next;
            copyHead = copyHead.next;
        }
        return map.get(head);
    }

    /**
     * 추가적인 공간없이 원본 수정으로 문제 해결
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. 노드 복사본을 원본 노드 사이에 끼워 넣는다.
        Node cur = head;
        while (cur != null) {
            // 카피본의 랜덤 값까지 복사해서 넣지는 않는다.
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 2. 복사 노드들의 random 포인터 설정
        cur = head;
        while (cur != null) {
            if (cur.random != null) { // 원본 노드
                // cur.next.random => 원본 카피 노드
                // cur.random.next => 원본 랜덤 노드의 카피 노드
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. 원본 리스트와 복사 리스트 분리
        Node dummyHead = new Node(0);
        Node copyCur = dummyHead;
        cur = head;

        while (cur != null) {
            Node copy = cur.next;
            copyCur.next = copy;
            copyCur = copy;

            cur.next = copy.next; // copy 건너뛰기
            cur = cur.next;
        }
        return copyCur;
    }
}
