package linked_list;

/**
 * 순차검색도 o(n) 이고 삭제 의 경우도 중간 삭제면 o(n)  이 걸리기 때문에
 * 처음과 끝을 삭제하는 경우가 아니고선 사용할 일이 거의 없고 더좋은 자료구조가 많기 때문에
 * 사용빈도는 낮다. 하지만 자료구조 공부 목적으로는 굉장히 도움되는 자료구조다.
 */
public class MyLinkedList {
    private SinglyNode head;
    private SinglyNode tail;
    private int count = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (head == null) return -1;
        if (index >= count) return -1;
        if (index == 0) return head.val;
        if (index == count - 1) return tail.val;
        SinglyNode node = head;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyNode(val);
            tail = head;
        } else {
            SinglyNode newHead = new SinglyNode(val);
            newHead.next = head;
            head = newHead;
        }
        count++;
    }

    public void printAllNode() {
        SinglyNode node = head;
        while (node != null) {
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = new SinglyNode(val);
            tail = head;
        } else {
            SinglyNode newTail = new SinglyNode(val);
            tail.next = newTail;
            tail = newTail;
        }
        count++;
    }

    public void addAtIndex(int index, int val) {
        if (index > count || index < 0) return;

        SinglyNode newNode = new SinglyNode(val);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (count == 0) tail = newNode;
        } else {
            SinglyNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            if (newNode.next == null) {
                tail = newNode;  // tail 갱신
            }
        }
        count++;
    }

    public void deleteAtIndex(int index) {
        if (index >= count || index < 0) return;

        if (index == 0) {
            head = head.next;
            if (count == 1) tail = null;  // 리스트가 비게 되면 tail 도 null 처리
        } else {
            SinglyNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            SinglyNode nodeToDelete = prev.next;
            prev.next = nodeToDelete.next;
            if (prev.next == null) {
                tail = prev;  // tail 갱신
            }
        }
        count--;
    }
}

