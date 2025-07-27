package recursion_1;

import binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_2 {
    public static void main(String[] args) {
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    /**
     * 솔직히 못풀었다 이거 재귀 반복 머리속에서 뱅글뱅글 돌다가 이해가 안됨 .복습 필요
     */
    private List<TreeNode> build(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            // i를 루트로 선택
            List<TreeNode> leftTrees = build(start, i - 1);
            List<TreeNode> rightTrees = build(i + 1, end);

            // 모든 조합 붙이기
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
