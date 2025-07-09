package binary_search_tree;

import java.util.Stack;

public class BSTIterator {

    public Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        treeSetUp(root);
    }

//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(7);
//        treeNode.left = new TreeNode(3);
//        treeNode.right  = new TreeNode(15);
//        treeNode.right.left = new TreeNode(9);
//        treeNode.right.right = new TreeNode(20);
//        BSTIterator bstIterator = new BSTIterator(treeNode);
//        while(!bstIterator.stack.isEmpty()) {
//            System.out.println(bstIterator.stack.pop());
//        }
//    }

    private void treeSetUp(TreeNode root) {
        if(root != null) {
            treeSetUp(root.right);
            stack.push(root);
            treeSetUp(root.left);
        }
    }

    public int next() {
        if(stack.isEmpty()) return -1;
        return stack.pop().val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
