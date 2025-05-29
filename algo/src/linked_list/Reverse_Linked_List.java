package linked_list;

public class Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        final ListNode node1 = _reverseListRecur(node);
        printAllNode(node1);
//        reverseList(node);
    }

    /**
     * 리스트 역방향으로 구하기
     * 이렇게 풀어봤는데 이렇게 인덱스로 조정하는건 좋은 방식이 아니라고 한다..
     * The number of nodes in the list is the range [0, 5000].
     * -5000 <= Node.val <= 5000
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        int cnt = 0;
        ListNode cur = head;
        while (cur.next != null) {
            cnt++;
            cur = cur.next;
        }

        for (int i = cnt; i > 0; i--) {
            ListNode tmp = cur.next;
            cur.next = head;
            head = head.next;
            cur.next.next = tmp;
        }
        return head;
    }

    /**
     * 반복 방식
     */
    public static ListNode _reverseList(ListNode head) {
        // 과거 번수를 하나두고 하나씩 뒤로 변경하는식으로 코드를 짠다.
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 재귀적 방식
     */
    public static ListNode _reverseListRecur(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }else {
            // 여기서 포인트는 마지막 노드를 유지해야 하는 것인데.
            ListNode node = _reverseListRecur(head.next);
            // head.next.next 는 항상 null 이 되므로 (그이전 재귀 스택에서 null 로 변경하므로)
            // 순서가 굉장히 중요해진다.
            head.next.next = head;
            head.next = null;
            return node;
        }
    }

    public static void printAllNode(ListNode node) {
        ListNode cur = node;
        while(cur != null) {
            System.out.println("cur.val = " + cur.val);
            cur = cur.next;
        }
    }
}
