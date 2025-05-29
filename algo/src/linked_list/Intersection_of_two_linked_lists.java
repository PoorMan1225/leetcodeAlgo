package linked_list;

public class Intersection_of_two_linked_lists {
    public static void main(String[] args) {

    }

    /**
     * 다른 방법이 생각 나지 않아서 길이 비교 방식으로 풀었다.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getNodeCount(headA);
        int lenB = getNodeCount(headB);

        // 더 긴 리스트의 포인터를 앞으로 이동
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // 교차 지점 찾기
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;  // 교차 지점 또는 null
    }

    /**
     * 투포인터 방식 풀이
     *  다음에는 a node 의 처음으로 돌아가게 된다.
     *  이것은 사실 a + b node 전체를 순회하게 만들게 되는데
     *  A node [1, 2, 3, 4, 5, 6]
     *  B node [7, 8, 4, 5, 6]
     *  A node [1, 2, 3, 4, 5, 6, 7, 8, 4]
     *  B node [7, 8, 4, 5, 6, 1, 2, 3, 4]
     *  이렇게 되어서 4 에서 겹치게 된다.
     */
    public ListNode __getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        // 1. 두 노드가 같지 않을때 까지 반복한다.
        // null 이어도 반복하게 된다.
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        // 두노드가 null 에서 만날경우 교차점이 존재하지 않는다.
        return a;
    }

    // 포인터 주소 복사.
    private int getNodeCount(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
