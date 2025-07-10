package binary_search_tree;

public class Insert_Into_a_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode prev = null;
        TreeNode tmp = root;
        while (tmp != null) {
            prev = tmp;
            if (tmp.val < val) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }
        return root;
    }

    /**
     * 그냥 반복문에서 처리하는 방식
     */
    public TreeNode __insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }
}
