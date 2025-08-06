package recursion_2;

import binary_search_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Same_Tree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        // 초기화
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(p);
        deque.addLast(q);

        // 반복 체크
        while(!deque.isEmpty()) {
            p = deque.removeFirst();
            q = deque.removeFirst();

            if(!check(p, q)) return false;

            if (!check(p.left, q.left)) return false;
            // 둘다 null 이면 값을 넣으면 안됨. deque 는 null 을 넣었을때 exception 을 던짐.
            if (p.left != null) {
                deque.addLast(p.left);
                deque.addLast(q.left);
            }

            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
                deque.addLast(p.right);
                deque.addLast(q.right);
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val;
    }
}
