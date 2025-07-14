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
            // child 가 존재하지 않을때는 그냥 null 을 리턴해서 null 을 넣어주면된다 .
            if (root.left == null && root.right == null) return null;

            // 왼쪽 또는 오른쪽이 없을 경우 있는 쪽의 노드를 그냥 이어주면된다
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3: two children
            TreeNode successor = findMin(root.right); // 오른쪽 서브트리에서 최소값 찾기
            root.val = successor.val; // 값을 바꾸고
            // 그냥 자기자신을 리턴해서 값을 돌아오게 만듬
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
