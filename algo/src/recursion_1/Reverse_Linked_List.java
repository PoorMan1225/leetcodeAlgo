package recursion_1;

import linked_list.ListNode;

public class Reverse_Linked_List {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    /**
     * 전위 재귀
     */
    public ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) return prev;

        ListNode next = node.next;
        node.next = prev;

        return reverse(next, node); // 마지막 노드를 반환하게 된다.
    }

    /**
     * 후위 재귀
     */
    public ListNode reverse(ListNode head) {
        // 마지막 노드를 찾아보자.
        if (head == null || head.next == null) return head;

        // 계속 다음으로 가서 마지막 노들르 찾는다.
        ListNode reversedHead = reverse(head.next);

        // 현재 내 노드의 다음다음에 나를 넣고
        head.next.next = head;
        // 나의 다음을 null 로 만든다
        head.next = null;

        return reversedHead;
    }
}
