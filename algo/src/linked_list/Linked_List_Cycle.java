package linked_list;

import java.util.HashSet;
import java.util.Set;

public class Linked_List_Cycle {
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        final boolean b = hasCycle(root);
        System.out.println("b = " + b);
    }

    /**
     * 객체참조 문제를 익숙하지 않아서 전혀 생각 못했다. ㅋㅋ
     * index 로 어떻게 해볼려 하다가 불가능 하단걸 깨닫고 어떻게 하지 하는데
     * 객체가 들어오면 객체의 주소가 있기 때문에 우리가 고유값을 정해줄 필요가 없다
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 플로이드의 토끼와 거북이 알고리즘
     * slowPtr 한칸씩 전진하는 거북이
     * fastPtr 두칸씩 전진하는 토끼
     *
     * Set 을 사용한 참조 주소 비교보다 빠르다 왜냐하면
     * set 은 add 시점에 hashcode 와 equals 연산 비교를 하기 때문에 느릴 수 있다.
     */
    public boolean __hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 한칸씩 전진하는 거북이
        ListNode slowPtr = head;
        // 두칸씩 전진하는 토끼
        ListNode fastPtr = head.next;

        // 토끼와 거북이가 만날때까지 반복한다. 언젠가는 만나게 되어있음 (ex 시계)
        while (fastPtr != null && fastPtr.next != null && slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr == fastPtr;
    }
}
