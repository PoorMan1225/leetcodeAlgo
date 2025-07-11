package binary_search_tree;

public class Delete_Node_in_a_BST {
    public static void main(String[] args) {

    }

    /**
     * 재귀적으로 노드를 삭제한다.
     * 노드가 없으면 null 을 반환하게 된다.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // case 1: no child
            if (root.left == null && root.right == null) return null;

            // case 2: one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3: two children
            TreeNode successor = findMin(root.right); // 오른쪽 서브트리에서 최소값 찾기
            root.val = successor.val; // 값을 바꾸고
            root.right = deleteNode(root.right, successor.val); // 중복된 값 삭제
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
