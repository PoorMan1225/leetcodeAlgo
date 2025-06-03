package double_linked_list;

import java.util.Stack;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        root.child = new Node();
        root.child.val = 3;

        root.next = new Node();
        root.next.prev = root;
        root.next.val = 2;
        final Node flatten = flatten(root);
        printAllNode(flatten);
    }

    public static void printAllNode(Node node) {
        Node cur = node;
        while (cur != null) {
            System.out.println("cur.val = " + cur.val);
            cur = cur.next;
        }
    }

    /**
     * 스택을 사용한 방법
     * 처음에 값을 보관을 해야 된다고 생각해서 stack 을 떠올렸는데 코드 구현시 어려움이 있었다
     * linkedList 문제에서 stack 을 사용한다는게 뭔가 좀 커리큘럼에 문제가 있는게 아닐까 싶기도 하다.
     */
    public static Node flatten(Node head) {
        Node curr = head;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            // 자식 값이 존재하면 stack 에 현재 노드 다음 값을 보관한다.
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;  // 자식 값을 없애버려야 한다.
            }

            // 다음값이 존재하지 않는데 스택이 비어있지 않다면
            // 하위의 child 를 다 지나간것이므로 stack 에서 하나를 pop 한다.
            if (curr.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                curr.next = nextNode;
                nextNode.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    static Node tail = null;
    public static Node flattenRecur(Node head) {
        if (head == null) return null;
        head.prev = tail;
        tail = head;

        Node nextNode = head.next;

        head.next = flatten(head.child); // flatten child first
        head.child = null;
        tail.next = flatten(nextNode); // then flatten original next
        return head;
    }
}
