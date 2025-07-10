package binary_search_tree;

public class Search_in_a_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public TreeNode __searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val < val ?
                searchBST(root.right, val) :
                searchBST(root.left, val);
    }

    public TreeNode _searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
