package stack_and_queue;

import java.util.Stack;

public class 전위_중위_후위_스택 {
    public static class TreeNode {
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

    // 전위
    public void preorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            // 오른쪽 먼저 넣어야 왼쪽이 먼저 나옴
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // 중위
    public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 왼쪽 끝까지 내려감
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 왼쪽 끝에서 하나 꺼냄
            current = stack.pop();
            System.out.print(current.val + " ");
            // 오른쪽으로 이동
            current = current.right;
        }
    }

    // 후위 (스택)
    public void postorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        // 후위 순회 순서로 출력
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    // 후위 (prev)
    public void _postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // prev 변수는 오른쪽 방문하였는지를 판단한다.
        // 이렇게 해야 상위 중간노드 가  peek 로 자신이 방문될때를 판단할때
        // 오른쪽 노드 prev 가 자신의 right 와 같다면 방문이 가능한것.
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != prev) {
                    current = peek.right;
                } else {
                    System.out.print(peek.val + " ");
                    prev = stack.pop();
                }
            }
        }
    }
}
