package recursion_1;

import binary_search_tree.TreeNode;

public class Search_In_a_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val < val) return searchBST(root.right, val);
        else if(root.val == val) return root;
        else return searchBST(root.left, val);
    }
}
