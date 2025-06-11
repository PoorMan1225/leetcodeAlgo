package stack_and_queue;

import java.util.*;

public class Clone_Graph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
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

        for(Node n : node.neighbors) {
            if(visited.get(n.val) == null) {
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
            copy.neighbors.add(clone(neighbor, visited));
        }

        return copy;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;
    }
}
