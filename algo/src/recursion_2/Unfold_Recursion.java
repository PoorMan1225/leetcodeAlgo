package recursion_2;

import binary_search_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Unfold_Recursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) stack.push(i);
        while (!stack.isEmpty()) stack.pop();
        long end = System.nanoTime();
        System.out.println("Stack: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) deque.push(i);
        while (!deque.isEmpty()) deque.pop();
        end = System.nanoTime();
        System.out.println("Deque: " + (end - start));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p 와 q 가 둘다 null 이면 둘은 같은 트리다.
        if (p == null && q == null) return true;
        // 둘중 하나만 null 이면 둘은 다른 트리다.
        if (q == null || p == null) return false;
        // 둘 의 값이 다르다면 둘은 다른 트리다.
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTreeNoRercur(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;
        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            // p q 가 조건을 만족하지 않으면 false
            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}
