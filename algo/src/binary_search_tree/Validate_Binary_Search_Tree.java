package binary_search_tree;


public class Validate_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursive(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return recursive(node.left, min, node.val) &&
                recursive(node.right, node.val, max);
    }
}
