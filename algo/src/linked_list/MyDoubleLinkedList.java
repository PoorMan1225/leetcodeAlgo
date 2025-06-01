package linked_list;

public class MyDoubleLinkedList {
    private int count = 0;
    private DoublyListNode head;
    private DoublyListNode tail;

    public MyDoubleLinkedList() {

    }

    public int get(int index) {
        if (index >= count) return -1;
        if (index == 0) return head.val;
        if (index == count - 1) return tail.val;
        DoublyListNode cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    public void printAllNode() {
        DoublyListNode cur = head;
        while (cur != null) {
            System.out.println("cur.val = " + cur.val);
            cur = cur.next;
        }
    }

    public void printAllNodeReverse() {
        DoublyListNode cur = tail;
        while (cur != null) {
            System.out.println("cur.val = " + cur.val);
            cur = cur.prev;
        }
    }

    public void addAtHead(int val) {
        // 헤드가 없다면
        if (head == null) {
            head = new DoublyListNode(val);
            tail = head;
        } else {
            DoublyListNode newHead = new DoublyListNode(val);
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        count++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = new DoublyListNode(val);
            tail = head;
        } else {
            DoublyListNode newTail = new DoublyListNode(val);
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > count) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == count) {
            addAtTail(val);
        } else {
            DoublyListNode cur = head;
            int i = 0;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            DoublyListNode newNode = new DoublyListNode(val);
            cur.prev.next = newNode;
            newNode.prev = cur.prev;
            newNode.next = cur;
            cur.prev = newNode;
            count++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= count) return;
        if (index == 0) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = null;
                tail = null;
            }
        } else if (index == count - 1) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = null;
                tail = null;
            }
        } else {
            DoublyListNode cur = head;
            int i = 0;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.next = null;
            cur.prev = null;
        }
        count--;
    }
}
