package binary_search_tree;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    /**
     * bst 에서 루트 값을 변경하는데 문제 풀기가 쉽다.
     * root 값을 변경하면서 공통 조상을 찾는게 효과적이다.
     * 왜냐하면 root 의 왼족은 무조건 root 보다 작고 root 의 오른쪽은 루트보다 크기때문에
     * 좌우로 나뉜다면 무조건 root 가 공통 조상이고
     * 둘다 왼쪽에 있다면 왼쪽 노드로 값을 변경하면 된다
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
