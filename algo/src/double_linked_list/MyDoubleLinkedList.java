package double_linked_list;

/**
 * 노드를 자주 추가하거나 삭제 하는 경우 연결 리스트가 좋은 선택일 수 있다.
 *  -> 맨앞에 추가, 또는 맨뒤 삭제는 o(1) 이 걸리기 때문에
 *
 *  인덱스로 요소를 자주 접근해야 하는 경우 연결 리스트보다 배열이 더 나은 선택일 수 있다.
 *  -> 연결 리스트에서는 인덱스를 찾는데 무조건 o(n) 이걸리기 때문에
 */
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

    /**
     * 더블 연결 리스트 에서는 삭제할 노드가 주어져 있다고 가정 했을때
     * 단일 연결 리스트에서는 이전노드를 또 찾아야 하기 때문에 삭제 하는데도 o(n) 시간이 걸리지만
     * 더블 연결 리스트에서는 삭제 할때 이전 노드를 알기 때문에 o(1) 밖에 걸리지 않는다.
     *
     * 물론 인덱스만 주어지고 해당 노드 정보를 모를때는 index 에 노드를 찾아야 하기 때문에 똑같이 o(n) 이걸린다.
     */
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
