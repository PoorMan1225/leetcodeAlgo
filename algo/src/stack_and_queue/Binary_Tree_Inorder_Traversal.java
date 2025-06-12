package stack_and_queue;

import java.util.*;

public class Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {

    }

    /**
     * 재귀로 구현하면 너무 쉬운 문제 이기 때문에
     * 스택을 통해서 반복으로 구현했다. 스택을 통해서 구현하면 여러가지 이점이 있는데 속도면에서는 재귀가 빠를 수 도 있지만
     * 스택에 사이즈가 너무 커지게 되면 스택 오버 플로가 발 생할 수 있기 때문에 이경우 반복으로 해결할 수 있다.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Stack<TreeNode> stack = new Stack<>();
        // 방문 체크를 해야 하는데 동일한 숫자가 들어올 수 도 있기 때문에
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        visited.add(root);
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode t = stack.peek();
            if (t.left != null && !visited.contains(t.left)) {
                stack.push(t.left);
                visited.add(t.left);
                continue;
            }
            result.add(stack.pop().val);
            if (t.right != null && !visited.contains(t.right)) {
                stack.push(t.right);
                visited.add(t.right);
            }
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
