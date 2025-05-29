package linked_list;

public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        removeNthFromEnd(root, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
       int cnt = 0;
       ListNode cur = head;
       while(cur != null) {
           cur = cur.next;
           cnt++;
       }
       cur = head;
       if(cnt - n == 0) {
           head = head.next;
           return head;
       }
       ListNode prev = head;
       while(cnt - n > 0) {
           prev = cur;
           cur = cur.next;
           cnt--;
       }
       prev.next = cur.next;
       return head;
    }
}
