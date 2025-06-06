package double_linked_list;

public class Rotate_List {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        rotateRight(root, 2);
    }

    /**
     * 와따시 복잡하게 짯다 이거야
     */
    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if (count == 0) return head;
        int tailCount = count - (k % count);
        if (tailCount == count) return head;
        count = 0;
        cur = head;
        ListNode tail = null;
        while (cur != null) {
            count++;
            if (count == tailCount) {
                tail = cur;
                break;
            }
            cur = cur.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        head = newHead;
        return head;
    }

    /**
     * GPT 개선코드
     * 전체 길이를 계산하는 것과 마지막 노드를 발견하는것을 같이 할 수 있다.
     */
    public ListNode __rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. 전체 길이 계산 + 마지막 노드 참조
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. 회전 수를 줄여서 실제 이동해야 할 위치 계산
        k = k % length;
        if (k == 0) return head;

        int stepsToNewHead = length - k;

        // 3. new head 찾기
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // 4. 회전 수행
        newTail.next = null;
        tail.next = head;
        return newHead;
    }

    /**
     * fast slow 를 활용한 코드
     */
}
