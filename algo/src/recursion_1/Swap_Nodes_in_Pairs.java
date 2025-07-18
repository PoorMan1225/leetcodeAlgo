package recursion_1;

import linked_list.ListNode;

public class Swap_Nodes_in_Pairs {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. 첫 번째와 두 번째 노드를 가져온다.
        ListNode first = head;
        ListNode second = head.next;

        // 2. 첫 번째 노드의 다음을, 두 번째 노드 다음부터 재귀적으로 처리한 결과로 연결한다.
        first.next = swapPairs(second.next);

        // 3. 두 번째 노드를 첫 번째 앞으로 옮긴다 (스왑).
        second.next = first;

        // 4. 새로운 head는 second가 된다.
        return second;
    }
}
