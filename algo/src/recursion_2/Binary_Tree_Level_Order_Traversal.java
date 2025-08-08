package recursion_2;

import binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * level 과 size 가 동일할때 새로 list 를 생성하고 동일 레벨의 list 를 담는다.
     */
    public List<List<Integer>> __levelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        level(root,0,l);
        return l;
    }
    private void level(TreeNode root,int level,List<List<Integer>> l){
        if(root==null) return;
        if(level==l.size()){
            l.add(new ArrayList<>());
        }
        l.get(level).add(root.val);
        level(root.left,level+1,l);
        level(root.right,level+1,l);
    }
}
