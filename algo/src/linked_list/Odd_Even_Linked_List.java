package linked_list;

public class Odd_Even_Linked_List {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
//        oddEvenList(root);
        final ListNode result = __oddEvenList(root);
        printAllNode(result);

    }

    /**
     * 짝수번 인덱스와 홀수번 인덱스를 그룹화 시킨다.
     * 각 그룹된 노드들의 순서는 보장 되어야 한다.
     * o(1) 공간 , o(n) 시간 을 만족해야 한다.
     */
    public static ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode init = dummy;
        ListNode prev = null;
        ListNode curr = head;
        int index = 1;
        // 1. 짝수번 노드를 찾는다.
        while (curr != null) {
            if (index % 2 == 0) { // 짝수
                // 2. 짝수 일 경우 현재 노드를 지우고 더미 노드에 붙여 준다.
                // 현재 노드를 지우기 전에 더미 노드에 붙이고 더미노드를 갱신해준다.
                dummy.next = curr;
                dummy = dummy.next;
                // 현재 노드를 지운다.
                prev.next = curr.next;
                curr = curr.next;
                dummy.next = null;
            } else {
                // 2. 홀수 인 경우 무시하고 다음 노드로 가면된다.
                prev = curr;
                curr = curr.next;
            }
            index++;
        }

        // 2. 나머지 제거된 요소를 붙인다.
        if (prev != null) prev.next = init.next;
        return head;
    }

    /**
     * 재귀적으로 짤 수 있을까?
     */
    public static ListNode __oddEvenList(ListNode head) {
        ListNode dummyEven = new ListNode(0);
        final ListNode listNode = removeNode(null, head, dummyEven, 1);
        printAllNode(dummyEven);
        return listNode;
    }

    public static ListNode removeNode(ListNode prev, ListNode curr, ListNode append, int cnt) {
        if (curr == null) return null;

        if (cnt % 2 == 0) {
            // 짝수 인덱스일 때
            prev.next = curr.next;
            ListNode next = curr.next;
            curr.next = null;
            append.next = curr;

            // append도 다음 노드로 넘기기 (계속 이어 붙이기 위함)
            removeNode(prev, next, append.next, cnt + 1);
            return null; // 중간에 반환 안함
        } else {
            // 홀수 인덱스일 때
            removeNode(curr, curr.next, append, cnt + 1);
            return curr; 
        }
    }

    public static void printAllNode(ListNode head) {
        System.out.println("=================================");
        while (head != null) {
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }
}
