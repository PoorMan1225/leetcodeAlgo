package stack_and_queue;

import java.util.*;

public class Clone_Graph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        Node copyNode = new Node();
        copyNode.val = node.val;
        copyNode.neighbors = new ArrayList<>();
        cloneGraphRecur(node, copyNode, visited);
        return copyNode;
    }

    /**
     * 복사를 내가 해서 넘겨주고 연결할 노드 까지 내가 지정해주는데
     * 역할을 분리하면 재귀구조가 더 명료해질 수 있다. (재귀 구조를 좀더 공부를 해야할듯..)
     */
    public void cloneGraphRecur(Node node, Node copyNode, Map<Integer, Node> visited) {
        visited.put(copyNode.val, copyNode);

        for (Node n : node.neighbors) {
            if (visited.get(n.val) == null) {
                Node newNode = new Node();
                newNode.val = n.val;
                newNode.neighbors = new ArrayList<>();
                copyNode.neighbors.add(newNode);
                cloneGraphRecur(n, newNode, visited);
            } else {
                Node visitedNode = visited.get(n.val);
                copyNode.neighbors.add(visitedNode);
            }
        }
    }


    public Node __cloneGraph(Node node) {
        if (node == null) return null;
        return clone(node, new HashMap<>());
    }

    /**
     * 함수를 연결 하는 것과 새로운 노드를 생성하는 것을 모두 클론 함수가 하고 있다.
     * 내가 할 일을 함수에게 넘겨서 자동으로 처리되게 하는 것이 재귀 추상화 훈련
     */
    private Node clone(Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node copy = new Node();
        copy.val = node.val;
        copy.neighbors = new ArrayList<>();
        visited.put(copy.val, copy);

        for (Node neighbor : node.neighbors) {
            // 방문한 노드면 방문한 노드 추가.
            // 방문 하지 않았다면 신규 노드를 추가.
            copy.neighbors.add(clone(neighbor, visited));
        }

        return copy;
    }

    /**
     * 스택으로 구현 스택을 사용하면 순서가 반대로 되지만 노드의 연결은 순서가 그렇게 중요하지 않음.
     * neighbors 의 add 할때만 순서를 유지 해주면된다.
     */
    private Node __cloneGraphStack(Node node) {
        if (node == null) return null;

        Map<Integer, Node> visited = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        Node root = new Node(node.val, new ArrayList<>());
        visited.put(node.val, root);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    Node cloneNeighbor = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor.val, cloneNeighbor);
                    stack.push(neighbor);
                }
                visited.get(curr.val).neighbors.add(visited.get(neighbor.val));
            }
        }

        return root;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
