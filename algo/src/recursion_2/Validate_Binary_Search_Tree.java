package recursion_2;

import binary_search_tree.TreeNode;

public class Validate_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return recursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean recursive(TreeNode node, int minValue, int maxValue) {
        if (node == null) return true;
        if (maxValue <= node.val || minValue >= node.val) {
            return false;
        }
        return recursive(node.left, minValue, node.val)
                && recursive(node.right, node.val, maxValue);
    }
}
