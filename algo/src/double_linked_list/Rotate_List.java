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
}
