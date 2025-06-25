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

    /**
     * 재귀적 코드
     * tail 로 마지막 변수를 유지하면서 재귀적으로 접근한다.
     * stackframe 범위 밖에 있는 tail 로 유지를 해야 하는데 유지하지 않고 구현하는 방법도 존재 하는것 같다.
     */
    static Node tail = null;
    public static Node flattenRecur(Node head) {
        if (head == null) return null;
        head.prev = tail; // 꼬리 부분을 이전으로 변경한다.
        tail = head; // head 와 tail 을 같게 유지한다.

        Node nextNode = head.next; // 다음 노드를 보관해야 한다 child 탐방이 끝난 후 nextNode 로 탐방을 재순회 해야 한다.

        head.next = flattenRecur(head.child); // child 부분을 탐방한다.
        head.child = null;               // head 의 child 를 null 로 만들어서 연결을 끊어야 한다.
        tail.next = flattenRecur(nextNode);   // tail 이 꼬리 노드를 유지하기 때문에 꼬리노드 기준으로 다음 노드를 붙인다.
        return head;                     // 이부분이 의외로 굉장히 중요한데. 현재노드가 종료될때 반환해야지 이전노드의 next 에 연결할 수 있다.
    }
}
