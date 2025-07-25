package recursion_1;

import linked_list.ListNode;

public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 둘중에 작은 값이 백트래킹으로 계속 넘어오기 때문에
        // 작은 값을 가진 노드의 다음에 계속 붙여주면 된다.
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
