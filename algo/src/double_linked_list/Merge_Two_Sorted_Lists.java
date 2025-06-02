package double_linked_list;

public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(2);
        root1.next.next = new ListNode(3);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(1);
        root2.next.next = new ListNode(2);
        root2.next.next.next = new ListNode(3);

    }

    /**
     * 문제 설명
     * 두개의 정렬 리스트의 헤드가 주어지고 두 리스트를 하나의 정렬된 리스트로 병합한다.
     * 병합된 연결 리스트의 헤드를 반환한다.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
            }
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 노드가 끝난 후에 그냥 다음 노드를 붙여버리면 된다.
     */
    public ListNode __mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // 더미 노드 (시작점)
        ListNode cur = dummy;

        // 두 리스트 모두 null이 아닐 동안 반복
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 둘 중 하나가 남아있을 경우 연결
        cur.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    /**
     * 재귀적으로 해볼 수 있나?
     */

    public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
        // 둘중 하나가 null 이면 나머지 node 를 붙이면 된다.
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 둘중에 작은 값이 백트래킹으로 계속 넘어오기 때문에
        // 작은 값을 가진 노드의 다음에 계속 붙여주면 된다.
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecur(l1, l2.next);
            return l2;
        }
    }

    public static void printAllNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println("cur.val = " + cur.val);
            cur = cur.next;
        }
    }
}
