package linked_list;

public class Remove_Linked_List_Elements {
    public static void main(String[] args) {

    }

    /**
     * 특정 값이 주어지면 해당 값의 노드를 모두 삭제한다.
     * The number of nodes in the list is in the range [0, 104].
     * 1 <= Node.val <= 50
     * 0 <= val <= 50
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if(curr.val != val) {
                prev = curr;
                curr = curr.next;
            } else {
                if(prev == null) {
                    curr = curr.next;
                    head = curr;
                }else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
        }
        return head;
    }

    /**
     * 더미노드를 사용해서 개선된 코드
     * 더미 노드가 있으면 prev 의 null 체크가 필요 없어진다.
     * 그리고 무조건 더미노드 다음이 head 가 되므로 head 를 유지하는 것도 필요 없어진다.
     */
    public ListNode __removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1); // 더미 노드 사용
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next; // 삭제
            } else {
                prev = curr; // 유지
            }
            curr = curr.next;
        }

        return dummy.next; // 실제 head는 dummy.next
    }

    /**
     * 재귀적 코드
     * 헤드의 다음 값을 넘기면서 마지막에 도달하면 백트래킹으로 만약 지워야할 노드라면
     * 그다음 노드를 리턴하는식 으로 노드를 제거한다.
     */
    public ListNode ___removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
