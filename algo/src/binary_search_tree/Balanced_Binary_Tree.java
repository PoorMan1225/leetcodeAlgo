package binary_search_tree;

public class Balanced_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        isBalanced(root);
    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null)
            leftDepth = nodeDepth(root.left, leftDepth + 1);
        if (root.right != null)
            rightDepth = nodeDepth(root.right, rightDepth + 1);
        if (leftDepth < 0 || rightDepth < 0) return false;
        return Math.abs(leftDepth - rightDepth) <= 1;
    }
    /**
     * 백트래킹 기반 bottom - up 사실 bottom up 은 다 백트래킹 기반
     */
    public static int nodeDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        int leftDepth = depth;
        int rightDepth = depth;

        if (node.left != null) {
            leftDepth = nodeDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            rightDepth = nodeDepth(node.right, depth + 1);
        }
        if (leftDepth < 0 || rightDepth < 0) return -1;
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) : -1;
    }

    /**
     * bottom - up 방식
     * depth 를 안넘기고 그냥 아래에서 위로 하나씩 올려서 값을 갱신해서 올리는 방법
     */
    public static boolean __isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 노드의 높이를 반환하고, 불균형이면 -1을 반환
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
