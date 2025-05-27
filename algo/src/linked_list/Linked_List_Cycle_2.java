package linked_list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Linked_List_Cycle_2 {
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        final ListNode listNode = __detectCycle(root);
        System.out.println("listNode.val = " + listNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 토끼와 거북이 알고리즘을 활용하여 순회 노드를 판단
     * 자세한 내용 floyd_cycle_detection_summary.md 파일 참조.
     */
    public static ListNode __detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 1. slow 노드와 fast 노드의 만나는 지점을 파악한다.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        // 2. 순회 구간이 존재하지 않는다.
        if (fast == null || fast.next == null) return null;

        // 3. 거북이의 위치를 헤더로 변경하고 두 노드를 한칸씩 전진한다.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
